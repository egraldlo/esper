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
package com.espertech.esper.epl.core.eval;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.EventType;
import com.espertech.esper.epl.core.SelectExprProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EvalInsertNoWildcardSingleColCoercionBean extends EvalBaseFirstProp implements SelectExprProcessor {

    private static final Logger log = LoggerFactory.getLogger(EvalInsertNoWildcardSingleColCoercionBean.class);

    public EvalInsertNoWildcardSingleColCoercionBean(SelectExprContext selectExprContext, EventType resultEventType) {
        super(selectExprContext, resultEventType);
    }

    public EventBean processFirstCol(Object result) {
        return super.getEventAdapterService().adapterForTypedBean(result, super.getResultEventType());
    }
}
