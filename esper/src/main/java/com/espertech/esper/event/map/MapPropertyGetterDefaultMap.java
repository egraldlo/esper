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
package com.espertech.esper.event.map;

import com.espertech.esper.client.EventType;
import com.espertech.esper.codegen.core.CodegenContext;
import com.espertech.esper.codegen.core.CodegenMember;
import com.espertech.esper.codegen.model.expression.CodegenExpression;
import com.espertech.esper.event.BaseNestableEventUtil;
import com.espertech.esper.event.EventAdapterService;

import static com.espertech.esper.codegen.model.expression.CodegenExpressionBuilder.ref;
import static com.espertech.esper.codegen.model.expression.CodegenExpressionBuilder.staticMethod;

/**
 * Getter for map entry.
 */
public class MapPropertyGetterDefaultMap extends MapPropertyGetterDefaultBase {

    public MapPropertyGetterDefaultMap(String propertyName, EventType fragmentEventType, EventAdapterService eventAdapterService) {
        super(propertyName, fragmentEventType, eventAdapterService);
    }

    protected Object handleCreateFragment(Object value) {
        return BaseNestableEventUtil.handleBNCreateFragmentMap(value, fragmentEventType, eventAdapterService);
    }

    protected CodegenExpression handleCreateFragmentCodegen(CodegenExpression value, CodegenContext context) {
        CodegenMember mType = context.makeAddMember(EventType.class, fragmentEventType);
        CodegenMember mSvc = context.makeAddMember(EventAdapterService.class, eventAdapterService);
        return staticMethod(BaseNestableEventUtil.class, "handleBNCreateFragmentMap", value, ref(mType.getMemberName()), ref(mSvc.getMemberName()));
    }
}
