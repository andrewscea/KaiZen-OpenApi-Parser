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
package com.reprezen.swaggerparser;

import java.io.IOException;

import org.apache.commons.cli.ParseException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator;

public class GenSwagger3 {
    public static void main(String[] args)
            throws JsonParseException, JsonMappingException, IOException, ParseException {
        CodeGenerator.main(new String[] { //
                "-t", "types3.yaml", //
                "-p", "com.reprezen.swaggerparser", //
                "-i", "model3", //
                "-I", "model3", //
                "-c", "impl3", //
                "-C", "impl3" //
                // , "-n" // uncomment to run in no-preserve mode
        });
    }
}
