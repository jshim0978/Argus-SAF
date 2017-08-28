/*
 * Copyright (c) 2017. Fengguo Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.amandroid.alir.summaryBasedAnalysis.wu

import org.argus.amandroid.alir.pta.model.InterComponentCommunicationModel
import org.argus.jawa.alir.controlFlowGraph.ICFGLocNode
import org.argus.jawa.alir.pta.PTAResult
import org.argus.jawa.alir.pta.model.ModelCallHandler
import org.argus.jawa.alir.pta.reachingFactsAnalysis.SimHeap
import org.argus.jawa.summary.wu.DataFlowWu
import org.argus.jawa.compiler.parser.CallStatement
import org.argus.jawa.core.JawaMethod
import org.argus.jawa.core.util.MList
import org.argus.jawa.summary.{SummaryManager, SummaryRule}

class IntentWu(
    method: JawaMethod,
    sm: SummaryManager,
    handler: ModelCallHandler)(implicit heap: SimHeap) extends DataFlowWu(method, sm, handler) {
  override def processNode(node: ICFGLocNode, ptaresult: PTAResult, rules: MList[SummaryRule]): Unit = {
    val l = method.getBody.resolvedBody.location(node.locIndex)
    l.statement match {
      case cs: CallStatement if InterComponentCommunicationModel.isIccOperation(cs.signature) =>

      case _ =>
    }
  }
}