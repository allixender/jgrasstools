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
import org.jgrasstools.modules.MeltonNumber; 
 
@Algorithm(version = "1.0.0", abstrakt = "Melton number calculator")
public class MeltonNumberAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(MeltonNumberAlgorithm.class); 

  public MeltonNumberAlgorithm() { 
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
  private String infans;

  @LiteralDataInput(identifier = "inFans", abstrakt = "The map of polygons of the fans.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinFans(String infans) { 
    this.infans = infans;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String fid;

  @LiteralDataInput(identifier = "fId", abstrakt = "The fields of the polygons containing the id of the polygon.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setfId(String fid) { 
    this.fid = fid;
  }

    // inputOutputIndicator = output
    // fileIndicator = null
    // fieldType = String[][]
    // fieldBindingType = String
    // fieldVariableType = String
  private String res_outmelton;

  @LiteralDataOutput(identifier = "res_outMelton", abstrakt = "The Melton numbers per id [id, num].", binding = LiteralStringBinding.class)
  public String getRes_outMelton() { 
    return res_outmelton;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.MeltonNumberAlgorithm");
    
    MeltonNumber tmpModule = new MeltonNumber(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("inElev",  (String) inelev); 
    logger.info("inElev " + ( (String) inelev) );
    inputs.put("fId",  (String) fid); 
    logger.info("fId " + ( (String) fid) );
    inputs.put("inFans",  (String) infans); 
    logger.info("inFans " + ( (String) infans) );
    
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
    
    outputs.put("outMelton", "String"); 
    
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outMelton")) { 
            // and put them into the output result variables 
            res_outmelton = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

