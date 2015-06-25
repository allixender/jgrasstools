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
import org.jgrasstools.modules.Insolation; 
 
@Algorithm(version = "1.0.0", abstrakt = "Calculate the amount of power incident on a surface in a period of time.")
public class InsolationAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(InsolationAlgorithm.class); 

  public InsolationAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inelev;

  @LiteralDataInput(identifier = "inElev", abstrakt = "The map of the elevation.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinElev(String inelev) { 
    this.inelev = inelev;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String tstartdate;

  @LiteralDataInput(identifier = "tStartDate", abstrakt = "The first day of the simulation.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void settStartDate(String tstartdate) { 
    this.tstartdate = tstartdate;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String tenddate;

  @LiteralDataInput(identifier = "tEndDate", abstrakt = "The last day of the simulation.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void settEndDate(String tenddate) { 
    this.tenddate = tenddate;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outins;

  @LiteralDataInput(identifier = "outIns", abstrakt = "The map of total insolation.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutIns(String outins) { 
    this.outins = outins;
  }

  private String res_outins;

  @LiteralDataOutput(identifier = "res_outIns", abstrakt = "The map of total insolation.", binding = LiteralStringBinding.class)
  public String getRes_outIns() { 
    return res_outins;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.InsolationAlgorithm");
    
    Insolation tmpModule = new Insolation(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("outIns",  (String) outins); 
    logger.info("outIns " + ( (String) outins) );
    inputs.put("tEndDate",  (String) tenddate); 
    logger.info("tEndDate " + ( (String) tenddate) );
    inputs.put("tStartDate",  (String) tstartdate); 
    logger.info("tStartDate " + ( (String) tstartdate) );
    inputs.put("inElev",  (String) inelev); 
    logger.info("inElev " + ( (String) inelev) );
    
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
    
    outputs.put("outIns", "String"); 
    
    res_outins = (String) outins; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outIns")) { 
            // and put them into the output result variables 
            res_outins = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

