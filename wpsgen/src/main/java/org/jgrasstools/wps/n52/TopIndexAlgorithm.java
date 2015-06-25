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
import org.jgrasstools.modules.TopIndex; 
 
@Algorithm(version = "1.0.0", abstrakt = "Topographic index calculator.")
public class TopIndexAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(TopIndexAlgorithm.class); 

  public TopIndexAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String intca;

  @LiteralDataInput(identifier = "inTca", abstrakt = "The map of the contributing area.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinTca(String intca) { 
    this.intca = intca;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inslope;

  @LiteralDataInput(identifier = "inSlope", abstrakt = "The map of slope.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinSlope(String inslope) { 
    this.inslope = inslope;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outtopindex;

  @LiteralDataInput(identifier = "outTopindex", abstrakt = "The map of the topographic index.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutTopindex(String outtopindex) { 
    this.outtopindex = outtopindex;
  }

  private String res_outtopindex;

  @LiteralDataOutput(identifier = "res_outTopindex", abstrakt = "The map of the topographic index.", binding = LiteralStringBinding.class)
  public String getRes_outTopindex() { 
    return res_outtopindex;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.TopIndexAlgorithm");
    
    TopIndex tmpModule = new TopIndex(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("inTca",  (String) intca); 
    logger.info("inTca " + ( (String) intca) );
    inputs.put("inSlope",  (String) inslope); 
    logger.info("inSlope " + ( (String) inslope) );
    inputs.put("outTopindex",  (String) outtopindex); 
    logger.info("outTopindex " + ( (String) outtopindex) );
    
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
    
    outputs.put("outTopindex", "String"); 
    
    res_outtopindex = (String) outtopindex; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outTopindex")) { 
            // and put them into the output result variables 
            res_outtopindex = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

