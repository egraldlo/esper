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
package com.espertech.esper.epl.datetime.reformatop;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.EventType;
import com.espertech.esper.epl.datetime.eval.DatetimeMethodEnum;
import com.espertech.esper.epl.join.plan.FilterExprAnalyzerAffector;
import com.espertech.esper.epl.expression.core.ExprEvaluatorContext;
import com.espertech.esper.epl.expression.core.ExprNode;
import com.espertech.esper.epl.expression.dot.ExprDotNodeFilterAnalyzerInput;
import com.espertech.esper.epl.expression.time.TimeAbacus;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ReformatOpFormat implements ReformatOp {

    private final DateFormat dateForma;
    private final DateTimeFormatter dateTimeFormatter;
    private final TimeAbacus timeAbacus;

    public ReformatOpFormat(Object formatter, TimeAbacus timeAbacus) {
        if (formatter instanceof DateFormat) {
            dateForma = (DateFormat) formatter;
            dateTimeFormatter = null;
        } else {
            dateForma = null;
            dateTimeFormatter = (DateTimeFormatter) formatter;
        }
        this.timeAbacus = timeAbacus;
    }

    public synchronized Object evaluate(Long ts, EventBean[] eventsPerStream, boolean newData, ExprEvaluatorContext exprEvaluatorContext) {
        if (timeAbacus.getOneSecond() == 1000L) {
            dateForma.format(ts);
        }
        return dateForma.format(timeAbacus.toDate(ts));
    }

    public synchronized Object evaluate(Date d, EventBean[] eventsPerStream, boolean newData, ExprEvaluatorContext exprEvaluatorContext) {
        return dateForma.format(d);
    }

    public synchronized Object evaluate(Calendar cal, EventBean[] eventsPerStream, boolean newData, ExprEvaluatorContext exprEvaluatorContext) {
        return dateForma.format(cal.getTime());
    }

    public Object evaluate(LocalDateTime ldt, EventBean[] eventsPerStream, boolean newData, ExprEvaluatorContext exprEvaluatorContext) {
        return ldt.format(dateTimeFormatter);
    }

    public Object evaluate(ZonedDateTime zdt, EventBean[] eventsPerStream, boolean newData, ExprEvaluatorContext exprEvaluatorContext) {
        return zdt.format(dateTimeFormatter);
    }

    public Class getReturnType() {
        return String.class;
    }

    public FilterExprAnalyzerAffector getFilterDesc(EventType[] typesPerStream, DatetimeMethodEnum currentMethod, List<ExprNode> currentParameters, ExprDotNodeFilterAnalyzerInput inputDesc) {
        return null;
    }
}
