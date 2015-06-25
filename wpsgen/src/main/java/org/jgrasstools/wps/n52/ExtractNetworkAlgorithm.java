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
import org.jgrasstools.modules.ExtractNetwork; 
 
@Algorithm(version = "1.0.0", abstrakt = "Extracts the raster network from an elevation model.")
public class ExtractNetworkAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(ExtractNetworkAlgorithm.class); 

  public ExtractNetworkAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String intca;

  @LiteralDataInput(identifier = "inTca", abstrakt = "The map of total contributing areas.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinTca(String intca) { 
    this.intca = intca;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inflow;

  @LiteralDataInput(identifier = "inFlow", abstrakt = "The optional map of flowdirections (needed for case with slope or topographic classes).", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinFlow(String inflow) { 
    this.inflow = inflow;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inslope;

  @LiteralDataInput(identifier = "inSlope", abstrakt = "The optional map of slope.", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinSlope(String inslope) { 
    this.inslope = inslope;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String intc3;

  @LiteralDataInput(identifier = "inTc3", abstrakt = "The optional map of aggregated topographic classes.", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinTc3(String intc3) { 
    this.intc3 = intc3;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double pthres;

  @LiteralDataInput(identifier = "pThres", abstrakt = "The threshold on the map.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpThres(double pthres) { 
    this.pthres = pthres;
  }

    // inputOutputIndicator = input
    // fileIndicator = combo:tca,tca and slope,tca in convergent sites
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String pmode;

  @LiteralDataInput(identifier = "pMode", abstrakt = "The thresholding mode (default is on tca).", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setpMode(String pmode) { 
    this.pmode = pmode;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double pexp;

  @LiteralDataInput(identifier = "pExp", abstrakt = "OmsTca exponent for the mode with slope or topographic classes (default = 0.5).", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpExp(double pexp) { 
    this.pexp = pexp;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outnet;

  @LiteralDataInput(identifier = "outNet", abstrakt = "The extracted network raster.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutNet(String outnet) { 
    this.outnet = outnet;
  }

  private String res_outnet;

  @LiteralDataOutput(identifier = "res_outNet", abstrakt = "The extracted network raster.", binding = LiteralStringBinding.class)
  public String getRes_outNet() { 
    return res_outnet;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.ExtractNetworkAlgorithm");
    
    ExtractNetwork tmpModule = new ExtractNetwork(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("outNet",  (String) outnet); 
    logger.info("outNet " + ( (String) outnet) );
    inputs.put("inTca",  (String) intca); 
    logger.info("inTca " + ( (String) intca) );
    inputs.put("inSlope",  (String) inslope); 
    logger.info("inSlope " + ( (String) inslope) );
    inputs.put("inTc3",  (String) intc3); 
    logger.info("inTc3 " + ( (String) intc3) );
    inputs.put("pMode",  (String) pmode); 
    logger.info("pMode " + ( (String) pmode) );
    inputs.put("inFlow",  (String) inflow); 
    logger.info("inFlow " + ( (String) inflow) );
    inputs.put("pExp",  (double) pexp); 
    logger.info("pExp " + ( (double) pexp) );
    inputs.put("pThres",  (double) pthres); 
    logger.info("pThres " + ( (double) pthres) );
    
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
    
    outputs.put("outNet", "String"); 
    
    res_outnet = (String) outnet; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outNet")) { 
            // and put them into the output result variables 
            res_outnet = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

