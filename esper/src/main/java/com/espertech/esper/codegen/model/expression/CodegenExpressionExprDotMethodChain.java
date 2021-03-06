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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CodegenExpressionExprDotMethodChain implements CodegenExpression {
    private final CodegenExpression expression;
    private final List<CodegenChainElement> chain = new ArrayList<>(2);

    public CodegenExpressionExprDotMethodChain(CodegenExpression expression) {
        this.expression = expression;
    }

    public void render(StringBuilder builder, Map<Class, String> imports) {
        expression.render(builder, imports);
        for (CodegenChainElement element : chain) {
            builder.append(".");
            element.render(builder);
        }
    }

    public CodegenExpressionExprDotMethodChain addNoParam(String method) {
        chain.add(new CodegenChainElement(method, null));
        return this;
    }

    public CodegenExpression addWConst(String method, Object ... constants) {
        chain.add(new CodegenChainElement(method, constants));
        return this;
    }

    public void mergeClasses(Set<Class> classes) {
        expression.mergeClasses(classes);
        for (CodegenChainElement element : chain) {
            element.mergeClasses(classes);
        }
    }
}
