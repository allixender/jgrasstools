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
import org.jgrasstools.modules.SplitSubbasins; 
 
@Algorithm(version = "1.0.0", abstrakt = "A tool for labeling the subbasins of a basin. Given the Hacks number of the channel network, the subbasin up to a selected order are labeled. If Hack order 2 was selected, the subbasins of Hack order 1 and 2 and the network of the same order are extracted.")
public class SplitSubbasinsAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(SplitSubbasinsAlgorithm.class); 

  public SplitSubbasinsAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inflow;

  @LiteralDataInput(identifier = "inFlow", abstrakt = "The map of flow direction.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinFlow(String inflow) { 
    this.inflow = inflow;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inhack;

  @LiteralDataInput(identifier = "inHack", abstrakt = "The map of hack.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinHack(String inhack) { 
    this.inhack = inhack;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double phackorder;

  @LiteralDataInput(identifier = "pHackorder", abstrakt = "The maximum hack order to consider for basin split.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpHackorder(Double phackorder) { 
    this.phackorder = phackorder;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outnetnum;

  @LiteralDataInput(identifier = "outNetnum", abstrakt = "The map of numbered network.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutNetnum(String outnetnum) { 
    this.outnetnum = outnetnum;
  }

  private String res_outnetnum;

  @LiteralDataOutput(identifier = "res_outNetnum", abstrakt = "The map of numbered network.", binding = LiteralStringBinding.class)
  public String getRes_outNetnum() { 
    return res_outnetnum;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outsubbasins;

  @LiteralDataInput(identifier = "outSubbasins", abstrakt = "The map of subbasins.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutSubbasins(String outsubbasins) { 
    this.outsubbasins = outsubbasins;
  }

  private String res_outsubbasins;

  @LiteralDataOutput(identifier = "res_outSubbasins", abstrakt = "The map of subbasins.", binding = LiteralStringBinding.class)
  public String getRes_outSubbasins() { 
    return res_outsubbasins;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.SplitSubbasinsAlgorithm");
    
    SplitSubbasins tmpModule = new SplitSubbasins(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("outSubbasins",  (String) outsubbasins); 
    logger.info("outSubbasins " + ( (String) outsubbasins) );
    inputs.put("pHackorder",  (Double) phackorder); 
    logger.info("pHackorder " + ( (Double) phackorder) );
    inputs.put("inFlow",  (String) inflow); 
    logger.info("inFlow " + ( (String) inflow) );
    inputs.put("inHack",  (String) inhack); 
    logger.info("inHack " + ( (String) inhack) );
    inputs.put("outNetnum",  (String) outnetnum); 
    logger.info("outNetnum " + ( (String) outnetnum) );
    
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
    
    outputs.put("outSubbasins", "String"); 
    outputs.put("outNetnum", "String"); 
    
    res_outsubbasins = (String) outsubbasins; 
    res_outnetnum = (String) outnetnum; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outSubbasins")) { 
            // and put them into the output result variables 
            res_outsubbasins = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outNetnum")) { 
            // and put them into the output result variables 
            res_outnetnum = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

