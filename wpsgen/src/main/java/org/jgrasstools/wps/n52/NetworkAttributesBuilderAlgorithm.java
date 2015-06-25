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
import org.jgrasstools.modules.NetworkAttributesBuilder; 
 
@Algorithm(version = "1.0.0", abstrakt = "Extracts network attributes and the vector network based on a raster network.")
public class NetworkAttributesBuilderAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(NetworkAttributesBuilderAlgorithm.class); 

  public NetworkAttributesBuilderAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String innet;

  @LiteralDataInput(identifier = "inNet", abstrakt = "The network raster map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinNet(String innet) { 
    this.innet = innet;
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
  private String intca;

  @LiteralDataInput(identifier = "inTca", abstrakt = "The map of tca.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinTca(String intca) { 
    this.intca = intca;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean dohack;

  @LiteralDataInput(identifier = "doHack", abstrakt = "Flag to also create the hack map.", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoHack(Boolean dohack) { 
    this.dohack = dohack;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outnet;

  @LiteralDataInput(identifier = "outNet", abstrakt = "The vector of the network.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutNet(String outnet) { 
    this.outnet = outnet;
  }

  private String res_outnet;

  @LiteralDataOutput(identifier = "res_outNet", abstrakt = "The vector of the network.", binding = LiteralStringBinding.class)
  public String getRes_outNet() { 
    return res_outnet;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outhack;

  @LiteralDataInput(identifier = "outHack", abstrakt = "The map of hack numbering.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutHack(String outhack) { 
    this.outhack = outhack;
  }

  private String res_outhack;

  @LiteralDataOutput(identifier = "res_outHack", abstrakt = "The map of hack numbering.", binding = LiteralStringBinding.class)
  public String getRes_outHack() { 
    return res_outhack;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.NetworkAttributesBuilderAlgorithm");
    
    NetworkAttributesBuilder tmpModule = new NetworkAttributesBuilder(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("outNet",  (String) outnet); 
    logger.info("outNet " + ( (String) outnet) );
    inputs.put("inTca",  (String) intca); 
    logger.info("inTca " + ( (String) intca) );
    inputs.put("inNet",  (String) innet); 
    logger.info("inNet " + ( (String) innet) );
    inputs.put("inFlow",  (String) inflow); 
    logger.info("inFlow " + ( (String) inflow) );
    inputs.put("doHack",  (Boolean) dohack); 
    logger.info("doHack " + ( (Boolean) dohack) );
    inputs.put("outHack",  (String) outhack); 
    logger.info("outHack " + ( (String) outhack) );
    
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
    outputs.put("outHack", "String"); 
    
    res_outnet = (String) outnet; 
    res_outhack = (String) outhack; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outNet")) { 
            // and put them into the output result variables 
            res_outnet = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outHack")) { 
            // and put them into the output result variables 
            res_outhack = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

