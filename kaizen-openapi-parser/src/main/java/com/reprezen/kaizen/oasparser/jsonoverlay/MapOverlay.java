/*******************************************************************************
 *  Copyright (c) 2017 ModelSolv, Inc. and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     ModelSolv, Inc. - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.reprezen.kaizen.oasparser.jsonoverlay;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;

public class MapOverlay<OV extends JsonOverlay<?>> extends JsonOverlay<Map<String, OV>>
		implements CollectionOverlay<OV> {

	private final CollectionStore<OV> store = new CollectionStore<OV>(this);

	private MapOverlay(String key, JsonOverlay<?> parent) {
		super(key, (Map<String, OV>) null, parent);
	}

	public MapOverlay(String key, Collection<OV> overlays, JsonOverlay<?> parent, String keyPat) {
		this(key, parent);
		store.init(false, keyPat).load(CollectionData.of(overlays));
		reset(false);
	}

	public MapOverlay(String key, Map<String, OV> overlayMap, JsonOverlay<?> parent, String keyPat) {
		this(key, parent);
		store.init(false, keyPat).load(CollectionData.of(overlayMap));
		reset(false);
	}

	public MapOverlay(String key, JsonNode json, JsonOverlay<?> parent, JsonOverlayFactory<OV> factory, String keyPat) {
		this(key, parent);
		store.init(false, keyPat).load(CollectionData.of(json, parent, factory));
		reset(false);
	}

	public MapOverlay(String key, JsonOverlay<?> parent, JsonOverlayFactory<OV> factory, String keyPat) {
		this(key, parent);
		store.init(false, keyPat).load(CollectionData.of(parent.getResolvedJson(key), parent, factory));
		reset(false);
	}

	@Override
	public boolean isPresent() {
		return super.isPresent() && getJson().isObject();
	}

	private void reset(boolean invalidate) {
		super.set(store.getOverlayMap(), invalidate);
	}

	public OV get(String key) {
		return value.get(key);
	}

	public boolean containsKey(String key) {
		return value.containsKey(key);
	}

	public Collection<OV> getValues() {
		return value.values();
	}

	@Override
	public void set(Map<String, OV> overlayMap) {
		store.set(overlayMap);
		reset(true);
	}

	public void set(Collection<OV> overlays) {
		store.set(overlays);
		reset(true);
		invalidate();
	}

	@Override
	public IJsonOverlay<?> find(JsonPointer path) {
		if (path.matches()) {
			return this;
		} else if (path.mayMatchProperty()) {
			String key = path.getMatchingProperty();
			return containsKey(key) ? store.getOverlay(key).find(path.tail()) : null;
		} else {
			return null;
		}
	}
	
	public void clear() {
		if (store.size() > 0) {
			store.clear();
			reset(true);
		}
	}

	public int size() {
		return value.size();
	}

	@Override
	public Map<String, OV> fromJson() {
		return store != null ? store.getOverlayMap() : Collections.<String, OV>emptyMap();
	}

	@Override
	public JsonNode _createJson(boolean followRefs) {
		return store.createJson(followRefs);
	}

	public void set(String key, OV overlay) {
		if (value.containsKey(key)) {
			store.replace(key, overlay);
		} else {
			store.add(key, overlay);
		}
		reset(true);
	}

	public void add(OV overlay) {
		store.add(overlay);
		reset(true);
	}

	public void add(String key, OV overlay) {
		store.add(key, overlay);
		reset(true);
	}

	public void remove(String key) {
		store.remove(key);
		reset(true);
	}

	public void remove(int index) {
		store.remove(index);
		reset(true);
	}

	public void replace(String key, OV overlay) {
		store.replace(key, overlay);
		reset(true);
	}

	public void replace(int index, OV overlay) {
		store.replace(index, overlay);
		reset(true);
		invalidate();
	}

	@Override
	public CollectionStore<OV> getStore() {
		return store;
	}
}