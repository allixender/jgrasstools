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
import org.jgrasstools.modules.LeastCostFlowDirections; 
 
@Algorithm(version = "1.0.0", abstrakt = "Calculates the drainage directions following the least cost method.")
public class LeastCostFlowDirectionsAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(LeastCostFlowDirectionsAlgorithm.class); 

  public LeastCostFlowDirectionsAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inelev;

  @LiteralDataInput(identifier = "inElev", abstrakt = "The elevation map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinElev(String inelev) { 
    this.inelev = inelev;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean dotca;

  @LiteralDataInput(identifier = "doTca", abstrakt = "Flag to toggle tca calculation.", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoTca(Boolean dotca) { 
    this.dotca = dotca;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean doslope;

  @LiteralDataInput(identifier = "doSlope", abstrakt = "Flag to toggle slope calculation.", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoSlope(Boolean doslope) { 
    this.doslope = doslope;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean doaspect;

  @LiteralDataInput(identifier = "doAspect", abstrakt = "Flag to toggle aspect calculation.", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoAspect(Boolean doaspect) { 
    this.doaspect = doaspect;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outflow;

  @LiteralDataInput(identifier = "outFlow", abstrakt = "The map of flowdirections.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutFlow(String outflow) { 
    this.outflow = outflow;
  }

  private String res_outflow;

  @LiteralDataOutput(identifier = "res_outFlow", abstrakt = "The map of flowdirections.", binding = LiteralStringBinding.class)
  public String getRes_outFlow() { 
    return res_outflow;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outtca;

  @LiteralDataInput(identifier = "outTca", abstrakt = "The map of tca (optional).", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutTca(String outtca) { 
    this.outtca = outtca;
  }

  private String res_outtca;

  @LiteralDataOutput(identifier = "res_outTca", abstrakt = "The map of tca (optional).", binding = LiteralStringBinding.class)
  public String getRes_outTca() { 
    return res_outtca;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outaspect;

  @LiteralDataInput(identifier = "outAspect", abstrakt = "The map of aspect (optional).", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutAspect(String outaspect) { 
    this.outaspect = outaspect;
  }

  private String res_outaspect;

  @LiteralDataOutput(identifier = "res_outAspect", abstrakt = "The map of aspect (optional).", binding = LiteralStringBinding.class)
  public String getRes_outAspect() { 
    return res_outaspect;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outslope;

  @LiteralDataInput(identifier = "outSlope", abstrakt = "The map of slope (optional).", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutSlope(String outslope) { 
    this.outslope = outslope;
  }

  private String res_outslope;

  @LiteralDataOutput(identifier = "res_outSlope", abstrakt = "The map of slope (optional).", binding = LiteralStringBinding.class)
  public String getRes_outSlope() { 
    return res_outslope;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.LeastCostFlowDirectionsAlgorithm");
    
    LeastCostFlowDirections tmpModule = new LeastCostFlowDirections(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("outTca",  (String) outtca); 
    logger.info("outTca " + ( (String) outtca) );
    inputs.put("doAspect",  (Boolean) doaspect); 
    logger.info("doAspect " + ( (Boolean) doaspect) );
    inputs.put("outSlope",  (String) outslope); 
    logger.info("outSlope " + ( (String) outslope) );
    inputs.put("outFlow",  (String) outflow); 
    logger.info("outFlow " + ( (String) outflow) );
    inputs.put("doTca",  (Boolean) dotca); 
    logger.info("doTca " + ( (Boolean) dotca) );
    inputs.put("doSlope",  (Boolean) doslope); 
    logger.info("doSlope " + ( (Boolean) doslope) );
    inputs.put("inElev",  (String) inelev); 
    logger.info("inElev " + ( (String) inelev) );
    inputs.put("outAspect",  (String) outaspect); 
    logger.info("outAspect " + ( (String) outaspect) );
    
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
    
    outputs.put("outTca", "String"); 
    outputs.put("outSlope", "String"); 
    outputs.put("outFlow", "String"); 
    outputs.put("outAspect", "String"); 
    
    res_outtca = (String) outtca; 
    res_outslope = (String) outslope; 
    res_outflow = (String) outflow; 
    res_outaspect = (String) outaspect; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outTca")) { 
            // and put them into the output result variables 
            res_outtca = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outSlope")) { 
            // and put them into the output result variables 
            res_outslope = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outFlow")) { 
            // and put them into the output result variables 
            res_outflow = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outAspect")) { 
            // and put them into the output result variables 
            res_outaspect = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

