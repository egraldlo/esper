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
package com.espertech.esper.spatial.quadtree.mxcifrowindex;

import com.espertech.esper.spatial.quadtree.core.SupportQuadTreeToolUnique;
import com.espertech.esper.spatial.quadtree.core.SupportExecUniqueRandomIntPointsInSquare;
import com.espertech.esper.spatial.quadtree.core.SupportGeneratorPointUniqueByXYInteger;
import com.espertech.esper.spatial.quadtree.mxcif.MXCIFQuadTree;
import junit.framework.TestCase;

import static com.espertech.esper.spatial.quadtree.mxcif.SupportMXCIFQuadTreeUtil.MXCIF_FACTORY;
import static com.espertech.esper.spatial.quadtree.mxcifrowindex.SupportMXCIFQuadTreeRowIndexUtil.MXCIF_RI_ADDERUNIQUE;
import static com.espertech.esper.spatial.quadtree.mxcifrowindex.SupportMXCIFQuadTreeRowIndexUtil.MXCIF_RI_QUERIER;
import static com.espertech.esper.spatial.quadtree.mxcifrowindex.SupportMXCIFQuadTreeRowIndexUtil.MXCIF_RI_REMOVER;

public class TestMXCIFQuadTreeRowIndexRandomIntPointsInSquare extends TestCase {
    public void testRandomIntPoints() {
        SupportQuadTreeToolUnique<MXCIFQuadTree<Object>> tools = new SupportQuadTreeToolUnique<>(MXCIF_FACTORY, SupportGeneratorPointUniqueByXYInteger.INSTANCE, MXCIF_RI_ADDERUNIQUE, MXCIF_RI_REMOVER, MXCIF_RI_QUERIER, false);
        SupportExecUniqueRandomIntPointsInSquare.runAssertion(tools);
    }
}
