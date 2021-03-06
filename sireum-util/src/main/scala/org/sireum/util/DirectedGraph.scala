/*
Copyright (c) 2011-2013 Robby, Kansas State University.        
All rights reserved. This program and the accompanying materials      
are made available under the terms of the Eclipse Public License v1.0 
which accompanies this distribution, and is available at              
http://www.eclipse.org/legal/epl-v10.html                             
*/

package org.sireum.util

/**
 * @author <a href="mailto:robby@k-state.edu">Robby</a>
 */
object DirectedGraphUtil {
  def computePrePostNodeOrder[V, E](dg : org.jgrapht.DirectedGraph[V, E], v : V) = {
    val numOfNodes = dg.vertexSet.size
    val result = idmapEmpty[V, (Int, Int)](numOfNodes)
    val seen = idmapEmpty[V, V](numOfNodes)
    var preNum = 0
    var postNum = 0
      def dfs(v : V) : Unit = {
        if (seen.contains(v)) return
        seen.put(v, v)
        val pre = preNum
        preNum += 1
        val it = dg.outgoingEdgesOf(v).iterator
        while (it.hasNext) {
          dfs(dg.getEdgeTarget(it.next))
        }
        val post = postNum
        postNum += 1
        result(v) = (pre, post)
      }
    dfs(v)
    result
  }

  def postOrderedNodes[V](m : MMap[V, (Int, Int)]) = {
    val a = marrayEmpty[(V, Int)]
    m.foreach { e =>
      a += ((e._1, e._2._2))
    }
    a.sortBy(second2).map(first2)
  }
}