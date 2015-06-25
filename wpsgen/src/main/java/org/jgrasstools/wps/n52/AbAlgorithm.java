/* THIS FILE IS GENERATED, DO NOT EDIT, IT WILL BE OVERWRITTEN */
package org.jgrasstools.wps.n52; 
 
import java.util.Collection; 
import java.util.HashMap; 
import java.util.ArrayList; 
import java.util.List; 
import java.io.*; 
 
import oms3.Access; 
import oms3.ComponentAccess; 
import oms3.annotations.Execute; 
import oms3.annotations.Finalize; 
import oms3.annotations.Initialize; 
 
import org.n52.wps.server.AbstractAnnotatedAlgorithm;
import org.n52.wps.algorithm.annotation.*; 
 
import org.n52.wps.io.data.binding.literal.*; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
 
import org.geotools.process.ProcessException; 
import org.jgrasstools.modules.Ab; 
 
@Algorithm(version = "1.0.0", abstrakt = "Calculates the draining area per length unit.")
public class AbAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(AbAlgorithm.class); 

  public AbAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String intca;

  @LiteralDataInput(identifier = "inTca", abstrakt = "The map of the total contributing area.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinTca(String intca) { 
    this.intca = intca;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inplan;

  @LiteralDataInput(identifier = "inPlan", abstrakt = "The map of the planar curvatures.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinPlan(String inplan) { 
    this.inplan = inplan;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outab;

  @LiteralDataInput(identifier = "outAb", abstrakt = "The map of area per length.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutAb(String outab) { 
    this.outab = outab;
  }

  private String res_outab;

  @LiteralDataOutput(identifier = "res_outAb", abstrakt = "The map of area per length.", binding = LiteralStringBinding.class)
  public String getRes_outAb() { 
    return res_outab;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outb;

  @LiteralDataInput(identifier = "outB", abstrakt = "The map of contour line.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutB(String outb) { 
    this.outb = outb;
  }

  private String res_outb;

  @LiteralDataOutput(identifier = "res_outB", abstrakt = "The map of contour line.", binding = LiteralStringBinding.class)
  public String getRes_outB() { 
    return res_outb;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.AbAlgorithm");
    
    Ab tmpModule = new Ab(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("inTca",  (String) intca); 
    logger.info("inTca " + ( (String) intca) );
    inputs.put("outB",  (String) outb); 
    logger.info("outB " + ( (String) outb) );
    inputs.put("inPlan",  (String) inplan); 
    logger.info("inPlan " + ( (String) inplan) );
    inputs.put("outAb",  (String) outab); 
    logger.info("outAb " + ( (String) outab) );
    
    // trigger execution of the module 
    try { 
        java.util.logging.Logger uLog = java.util.logging.Logger.getLogger(RasterReprojectorAlgorithm.class.getName()); 
        ComponentAccess.setInputData(inputs, tmpModule, uLog); 
    } catch (Exception ex) { 
       ex.printStackTrace();
    }
    // trigger execution of the module 
    try { 
        java.util.logging.Logger uLog = java.util.logging.Logger.getLogger(RasterReprojectorAlgorithm.class.getName()); 
        ComponentAccess.callAnnotated(tmpModule, Initialize.class, true); 
    } catch (Exception ex) { 
       ex.printStackTrace();
    }
    try { 
        ComponentAccess.callAnnotated(tmpModule, Execute.class, false); 
    } catch (Exception ex) { 
       ex.printStackTrace();
    }
    try { 
        ComponentAccess.callAnnotated(tmpModule, Finalize.class, true); 
    } catch (Exception ex) { 
       ex.printStackTrace();
    }
    
    // get the results 
    HashMap<String, String> outputs = new HashMap<String, String>();
    ComponentAccess cA = new ComponentAccess(tmpModule); 
    Collection<Access> outputsCollection = cA.outputs(); 
    
    outputs.put("outB", "String"); 
    outputs.put("outAb", "String"); 
    
    res_outb = (String) outb; 
    res_outab = (String) outab; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outB")) { 
            // and put them into the output result variables 
            res_outb = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outAb")) { 
            // and put them into the output result variables 
            res_outab = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

