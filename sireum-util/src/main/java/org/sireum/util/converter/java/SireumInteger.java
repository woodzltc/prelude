/*
Copyright (c) 2011-2013 Robby, Kansas State University.        
All rights reserved. This program and the accompanying materials      
are made available under the terms of the Eclipse Public License v1.0 
which accompanies this distribution, and is available at              
http://www.eclipse.org/legal/epl-v10.html                             
*/

package org.sireum.util.converter.java;

import java.math.BigInteger;

/**
 * @author <a href="mailto:robby@k-state.edu">Robby</a>
 */
public class SireumInteger {
  private BigInteger value;

  public SireumInteger(BigInteger n) {
    this.value = n;
  }

  public BigInteger getValue() {
    return value;
  }

  public void setValue(BigInteger value) {
    this.value = value;
  }
}
