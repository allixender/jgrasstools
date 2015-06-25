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
import org.jgrasstools.modules.DebrisTriggerCnr; 
 
@Algorithm(version = "1.0.0", abstrakt = "Module for extraction of debris trigger points along the network following the CNR methodology.")
public class DebrisTriggerCnrAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(DebrisTriggerCnrAlgorithm.class); 

  public DebrisTriggerCnrAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inelev;

  @LiteralDataInput(identifier = "inElev", abstrakt = "The map of elevation.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinElev(String inelev) { 
    this.inelev = inelev;
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

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String intca;

  @LiteralDataInput(identifier = "inTca", abstrakt = "The map of tca.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinTca(String intca) { 
    this.intca = intca;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = km2
  private double ptcathres;

  @LiteralDataInput(identifier = "pTcathres", abstrakt = "The tca threshold to use (default = 10 km2).", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpTcathres(double ptcathres) { 
    this.ptcathres = ptcathres;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = degree
  private double pgradthres;

  @LiteralDataInput(identifier = "pGradthres", abstrakt = "The gradient threshold to use (default = 38 deg).", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpGradthres(double pgradthres) { 
    this.pgradthres = pgradthres;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outtriggers;

  @LiteralDataInput(identifier = "outTriggers", abstrakt = "The trigger map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutTriggers(String outtriggers) { 
    this.outtriggers = outtriggers;
  }

  private String res_outtriggers;

  @LiteralDataOutput(identifier = "res_outTriggers", abstrakt = "The trigger map.", binding = LiteralStringBinding.class)
  public String getRes_outTriggers() { 
    return res_outtriggers;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.DebrisTriggerCnrAlgorithm");
    
    DebrisTriggerCnr tmpModule = new DebrisTriggerCnr(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("outTriggers",  (String) outtriggers); 
    logger.info("outTriggers " + ( (String) outtriggers) );
    inputs.put("inTca",  (String) intca); 
    logger.info("inTca " + ( (String) intca) );
    inputs.put("inNet",  (String) innet); 
    logger.info("inNet " + ( (String) innet) );
    inputs.put("pTcathres",  (double) ptcathres); 
    logger.info("pTcathres " + ( (double) ptcathres) );
    inputs.put("inElev",  (String) inelev); 
    logger.info("inElev " + ( (String) inelev) );
    inputs.put("pGradthres",  (double) pgradthres); 
    logger.info("pGradthres " + ( (double) pgradthres) );
    
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
    
    outputs.put("outTriggers", "String"); 
    
    res_outtriggers = (String) outtriggers; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outTriggers")) { 
            // and put them into the output result variables 
            res_outtriggers = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

