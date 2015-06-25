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
import org.jgrasstools.modules.Tca3d; 
 
@Algorithm(version = "1.0.0", abstrakt = "Calculates the contributing areas considering also the elevation (3D), that represent the areas (in number of pixels) afferent to each point.")
public class Tca3dAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(Tca3dAlgorithm.class); 

  public Tca3dAlgorithm() { 
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

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outtca;

  @LiteralDataInput(identifier = "outTca", abstrakt = "The map of total contributing areas 3d.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutTca(String outtca) { 
    this.outtca = outtca;
  }

  private String res_outtca;

  @LiteralDataOutput(identifier = "res_outTca", abstrakt = "The map of total contributing areas 3d.", binding = LiteralStringBinding.class)
  public String getRes_outTca() { 
    return res_outtca;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.Tca3dAlgorithm");
    
    Tca3d tmpModule = new Tca3d(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("outTca",  (String) outtca); 
    logger.info("outTca " + ( (String) outtca) );
    inputs.put("inFlow",  (String) inflow); 
    logger.info("inFlow " + ( (String) inflow) );
    inputs.put("inPit",  (String) inpit); 
    logger.info("inPit " + ( (String) inpit) );
    
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
    
    res_outtca = (String) outtca; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outTca")) { 
            // and put them into the output result variables 
            res_outtca = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

