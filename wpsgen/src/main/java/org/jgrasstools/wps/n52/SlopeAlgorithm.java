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
import org.jgrasstools.modules.Slope; 
 
@Algorithm(version = "1.0.0", abstrakt = "Calculates the slope in each point of the map.")
public class SlopeAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(SlopeAlgorithm.class); 

  public SlopeAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inpit;

  @LiteralDataInput(identifier = "inPit", abstrakt = "The depitted elevation map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinPit(String inpit) { 
    this.inpit = inpit;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inflow;

  @LiteralDataInput(identifier = "inFlow", abstrakt = "The map of flowdirection.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinFlow(String inflow) { 
    this.inflow = inflow;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean dohandlenegativeslope;

  @LiteralDataInput(identifier = "doHandleNegativeSlope", abstrakt = "If true, negative slopes will be set to the minimum positive value.", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoHandleNegativeSlope(Boolean dohandlenegativeslope) { 
    this.dohandlenegativeslope = dohandlenegativeslope;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outslope;

  @LiteralDataInput(identifier = "outSlope", abstrakt = "The map of gradient.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutSlope(String outslope) { 
    this.outslope = outslope;
  }

  private String res_outslope;

  @LiteralDataOutput(identifier = "res_outSlope", abstrakt = "The map of gradient.", binding = LiteralStringBinding.class)
  public String getRes_outSlope() { 
    return res_outslope;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.SlopeAlgorithm");
    
    Slope tmpModule = new Slope(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("doHandleNegativeSlope",  (Boolean) dohandlenegativeslope); 
    logger.info("doHandleNegativeSlope " + ( (Boolean) dohandlenegativeslope) );
    inputs.put("outSlope",  (String) outslope); 
    logger.info("outSlope " + ( (String) outslope) );
    inputs.put("inFlow",  (String) inflow); 
    logger.info("inFlow " + ( (String) inflow) );
    inputs.put("inPit",  (String) inpit); 
    logger.info("inPit " + ( (String) inpit) );
    
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
    
    outputs.put("outSlope", "String"); 
    
    res_outslope = (String) outslope; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outSlope")) { 
            // and put them into the output result variables 
            res_outslope = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

