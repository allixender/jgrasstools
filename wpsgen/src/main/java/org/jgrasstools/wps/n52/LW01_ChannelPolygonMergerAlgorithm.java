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
import org.jgrasstools.modules.LW01_ChannelPolygonMerger; 
 
@Algorithm(version = "1.0.0", abstrakt = "Merges the adjacent bankfull polygons in a single geometry for further processing.")
public class LW01_ChannelPolygonMergerAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(LW01_ChannelPolygonMergerAlgorithm.class); 

  public LW01_ChannelPolygonMergerAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inbankfull;

  @LiteralDataInput(identifier = "inBankfull", abstrakt = "The input polygon layer of the bankfull area", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinBankfull(String inbankfull) { 
    this.inbankfull = inbankfull;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outbankfull;

  @LiteralDataInput(identifier = "outBankfull", abstrakt = "The output polygon of the bankfull area", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutBankfull(String outbankfull) { 
    this.outbankfull = outbankfull;
  }

  private String res_outbankfull;

  @LiteralDataOutput(identifier = "res_outBankfull", abstrakt = "The output polygon of the bankfull area", binding = LiteralStringBinding.class)
  public String getRes_outBankfull() { 
    return res_outbankfull;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.LW01_ChannelPolygonMergerAlgorithm");
    
    LW01_ChannelPolygonMerger tmpModule = new LW01_ChannelPolygonMerger(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("outBankfull",  (String) outbankfull); 
    logger.info("outBankfull " + ( (String) outbankfull) );
    inputs.put("inBankfull",  (String) inbankfull); 
    logger.info("inBankfull " + ( (String) inbankfull) );
    
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
    
    outputs.put("outBankfull", "String"); 
    
    res_outbankfull = (String) outbankfull; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outBankfull")) { 
            // and put them into the output result variables 
            res_outbankfull = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

