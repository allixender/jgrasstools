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
import org.jgrasstools.modules.H2cd; 
 
@Algorithm(version = "1.0.0", abstrakt = "It calculates for each hillslope pixel its distance from the river networks, following the steepest descent.")
public class H2cdAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(H2cdAlgorithm.class); 

  public H2cdAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inflow;

  @LiteralDataInput(identifier = "inFlow", abstrakt = "The map of flowdirections", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinFlow(String inflow) { 
    this.inflow = inflow;
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
  private String inelev;

  @LiteralDataInput(identifier = "inElev", abstrakt = "The optional map of the elevation used for 3d mode in pMode = 1.", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinElev(String inelev) { 
    this.inelev = inelev;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int pmode;

  @LiteralDataInput(identifier = "pMode", abstrakt = "The processing mode (0 = in number of pixels (default), 1 = in meters).", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpMode(int pmode) { 
    this.pmode = pmode;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outh2cd;

  @LiteralDataInput(identifier = "outH2cd", abstrakt = "The map of hillslope to channels distance.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutH2cd(String outh2cd) { 
    this.outh2cd = outh2cd;
  }

  private String res_outh2cd;

  @LiteralDataOutput(identifier = "res_outH2cd", abstrakt = "The map of hillslope to channels distance.", binding = LiteralStringBinding.class)
  public String getRes_outH2cd() { 
    return res_outh2cd;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.H2cdAlgorithm");
    
    H2cd tmpModule = new H2cd(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("inNet",  (String) innet); 
    logger.info("inNet " + ( (String) innet) );
    inputs.put("pMode",  (int) pmode); 
    logger.info("pMode " + ( (int) pmode) );
    inputs.put("outH2cd",  (String) outh2cd); 
    logger.info("outH2cd " + ( (String) outh2cd) );
    inputs.put("inElev",  (String) inelev); 
    logger.info("inElev " + ( (String) inelev) );
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
    
    outputs.put("outH2cd", "String"); 
    
    res_outh2cd = (String) outh2cd; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outH2cd")) { 
            // and put them into the output result variables 
            res_outh2cd = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

