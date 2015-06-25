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
import org.jgrasstools.modules.LW06_SlopeToNetworkAdder; 
 
@Algorithm(version = "1.0.0", abstrakt = "Add the local slope attribute to the input channel point layer.")
public class LW06_SlopeToNetworkAdderAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(LW06_SlopeToNetworkAdderAlgorithm.class); 

  public LW06_SlopeToNetworkAdderAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String innetpoints;

  @LiteralDataInput(identifier = "inNetPoints", abstrakt = "The input hierarchy point network layer.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinNetPoints(String innetpoints) { 
    this.innetpoints = innetpoints;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inslope;

  @LiteralDataInput(identifier = "inSlope", abstrakt = "The input slope raster map", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinSlope(String inslope) { 
    this.inslope = inslope;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outnetpoints;

  @LiteralDataInput(identifier = "outNetPoints", abstrakt = "The output points network layer with the additional attribute of local slope.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutNetPoints(String outnetpoints) { 
    this.outnetpoints = outnetpoints;
  }

  private String res_outnetpoints;

  @LiteralDataOutput(identifier = "res_outNetPoints", abstrakt = "The output points network layer with the additional attribute of local slope.", binding = LiteralStringBinding.class)
  public String getRes_outNetPoints() { 
    return res_outnetpoints;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.LW06_SlopeToNetworkAdderAlgorithm");
    
    LW06_SlopeToNetworkAdder tmpModule = new LW06_SlopeToNetworkAdder(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("inNetPoints",  (String) innetpoints); 
    logger.info("inNetPoints " + ( (String) innetpoints) );
    inputs.put("inSlope",  (String) inslope); 
    logger.info("inSlope " + ( (String) inslope) );
    inputs.put("outNetPoints",  (String) outnetpoints); 
    logger.info("outNetPoints " + ( (String) outnetpoints) );
    
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
    
    outputs.put("outNetPoints", "String"); 
    
    res_outnetpoints = (String) outnetpoints; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outNetPoints")) { 
            // and put them into the output result variables 
            res_outnetpoints = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

