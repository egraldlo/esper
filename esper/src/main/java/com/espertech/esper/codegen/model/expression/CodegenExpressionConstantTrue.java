/*
 ***************************************************************************************
 *  Copyright (C) 2006 EsperTech, Inc. All rights reserved.                            *
 *  http://www.espertech.com/esper                                                     *
 *  http://www.espertech.com                                                           *
 *  ---------------------------------------------------------------------------------- *
 *  The software in this package is published under the terms of the GPL license       *
 *  a copy of which has been included with this distribution in the license.txt file.  *
 ***************************************************************************************
 */
package com.espertech.esper.codegen.model.expression;

import java.util.Map;
import java.util.Set;

public class CodegenExpressionConstantTrue implements CodegenExpression {

    protected final static CodegenExpressionConstantTrue INSTANCE = new CodegenExpressionConstantTrue();

    private CodegenExpressionConstantTrue() {
    }

    public void render(StringBuilder builder, Map<Class, String> imports) {
        builder.append("true");
    }

    public void mergeClasses(Set<Class> classes) {
    }
}
