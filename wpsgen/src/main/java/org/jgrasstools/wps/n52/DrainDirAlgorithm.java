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
import org.jgrasstools.modules.DrainDir; 
 
@Algorithm(version = "1.0.0", abstrakt = "It calculates the drainage directions minimizing the deviation from the real flow")
public class DrainDirAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(DrainDirAlgorithm.class); 

  public DrainDirAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inpit;

  @LiteralDataInput(identifier = "inPit", abstrakt = "The depitted elevation model.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinPit(String inpit) { 
    this.inpit = inpit;
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
  private String inflownet;

  @LiteralDataInput(identifier = "inFlownet", abstrakt = "The map of flowdirections on the network pixels (considered only in case of LTD method). Remember that in the case of fixed flow calculation the tca has to be recalculated afterwards; the tca output in this case is not corrected.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinFlownet(String inflownet) { 
    this.inflownet = inflownet;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double plambda;

  @LiteralDataInput(identifier = "pLambda", abstrakt = "The direction correction factor.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpLambda(double plambda) { 
    this.plambda = plambda;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean dolad;

  @LiteralDataInput(identifier = "doLad", abstrakt = "Switch for the mode to use: true = LAD (default), false = LTD)).", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoLad(Boolean dolad) { 
    this.dolad = dolad;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outflow;

  @LiteralDataInput(identifier = "outFlow", abstrakt = "The map of drainage directions.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutFlow(String outflow) { 
    this.outflow = outflow;
  }

  private String res_outflow;

  @LiteralDataOutput(identifier = "res_outFlow", abstrakt = "The map of drainage directions.", binding = LiteralStringBinding.class)
  public String getRes_outFlow() { 
    return res_outflow;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outtca;

  @LiteralDataInput(identifier = "outTca", abstrakt = "The map of total contributing areas.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutTca(String outtca) { 
    this.outtca = outtca;
  }

  private String res_outtca;

  @LiteralDataOutput(identifier = "res_outTca", abstrakt = "The map of total contributing areas.", binding = LiteralStringBinding.class)
  public String getRes_outTca() { 
    return res_outtca;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.DrainDirAlgorithm");
    
    DrainDir tmpModule = new DrainDir(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("outTca",  (String) outtca); 
    logger.info("outTca " + ( (String) outtca) );
    inputs.put("pLambda",  (double) plambda); 
    logger.info("pLambda " + ( (double) plambda) );
    inputs.put("inFlownet",  (String) inflownet); 
    logger.info("inFlownet " + ( (String) inflownet) );
    inputs.put("outFlow",  (String) outflow); 
    logger.info("outFlow " + ( (String) outflow) );
    inputs.put("inFlow",  (String) inflow); 
    logger.info("inFlow " + ( (String) inflow) );
    inputs.put("inPit",  (String) inpit); 
    logger.info("inPit " + ( (String) inpit) );
    inputs.put("doLad",  (Boolean) dolad); 
    logger.info("doLad " + ( (Boolean) dolad) );
    
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
    outputs.put("outFlow", "String"); 
    
    res_outtca = (String) outtca; 
    res_outflow = (String) outflow; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outTca")) { 
            // and put them into the output result variables 
            res_outtca = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outFlow")) { 
            // and put them into the output result variables 
            res_outflow = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

