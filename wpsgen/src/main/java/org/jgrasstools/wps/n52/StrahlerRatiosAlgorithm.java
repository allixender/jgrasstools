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
import org.jgrasstools.modules.StrahlerRatios; 
 
@Algorithm(version = "1.0.0", abstrakt = "Calculates the OmsStrahler ratios.")
public class StrahlerRatiosAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(StrahlerRatiosAlgorithm.class); 

  public StrahlerRatiosAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inflow;

  @LiteralDataInput(identifier = "inFlow", abstrakt = "The map of flowdirections.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinFlow(String inflow) { 
    this.inflow = inflow;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String instrahler;

  @LiteralDataInput(identifier = "inStrahler", abstrakt = "The map of OmsStrahler.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinStrahler(String instrahler) { 
    this.instrahler = instrahler;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String innet;

  @LiteralDataInput(identifier = "inNet", abstrakt = "The map of the network.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinNet(String innet) { 
    this.innet = innet;
  }

    // inputOutputIndicator = output
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double res_outbisfurcation;

  @LiteralDataOutput(identifier = "res_outBisfurcation", abstrakt = "The bifurcation ratio.", binding = LiteralDoubleBinding.class)
  public double getRes_outBisfurcation() { 
    return res_outbisfurcation;
  }

    // inputOutputIndicator = output
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double res_outarea;

  @LiteralDataOutput(identifier = "res_outArea", abstrakt = "The area ratio.", binding = LiteralDoubleBinding.class)
  public double getRes_outArea() { 
    return res_outarea;
  }

    // inputOutputIndicator = output
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double res_outlength;

  @LiteralDataOutput(identifier = "res_outLength", abstrakt = "The length ratio.", binding = LiteralDoubleBinding.class)
  public double getRes_outLength() { 
    return res_outlength;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.StrahlerRatiosAlgorithm");
    
    StrahlerRatios tmpModule = new StrahlerRatios(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("inStrahler",  (String) instrahler); 
    logger.info("inStrahler " + ( (String) instrahler) );
    inputs.put("inNet",  (String) innet); 
    logger.info("inNet " + ( (String) innet) );
    inputs.put("inFlow",  (String) inflow); 
    logger.info("inFlow " + ( (String) inflow) );
    
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
    
    outputs.put("outArea", "double"); 
    outputs.put("outBisfurcation", "double"); 
    outputs.put("outLength", "double"); 
    
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outArea")) { 
            // and put them into the output result variables 
            res_outarea = (double) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outBisfurcation")) { 
            // and put them into the output result variables 
            res_outbisfurcation = (double) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outLength")) { 
            // and put them into the output result variables 
            res_outlength = (double) access.getFieldValue(); 
        }
        } 
    
    }

}

