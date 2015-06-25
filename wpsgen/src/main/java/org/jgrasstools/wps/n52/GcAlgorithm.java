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
import org.jgrasstools.modules.Gc; 
 
@Algorithm(version = "1.0.0", abstrakt = "Subdivides the sites of a basin in 11 topographic classes.")
public class GcAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(GcAlgorithm.class); 

  public GcAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inslope;

  @LiteralDataInput(identifier = "inSlope", abstrakt = "The map of the slope", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinSlope(String inslope) { 
    this.inslope = inslope;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String innetwork;

  @LiteralDataInput(identifier = "inNetwork", abstrakt = "The map with the network", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinNetwork(String innetwork) { 
    this.innetwork = innetwork;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String incp9;

  @LiteralDataInput(identifier = "inCp9", abstrakt = "The map with the Thopological classes cp9", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinCp9(String incp9) { 
    this.incp9 = incp9;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int pth;

  @LiteralDataInput(identifier = "pTh", abstrakt = "The gradient formula mode (0 = finite differences, 1 = horn, 2 = evans).", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpTh(int pth) { 
    this.pth = pth;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outclasses;

  @LiteralDataInput(identifier = "outClasses", abstrakt = "The map with the geomorphological classes", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutClasses(String outclasses) { 
    this.outclasses = outclasses;
  }

  private String res_outclasses;

  @LiteralDataOutput(identifier = "res_outClasses", abstrakt = "The map with the geomorphological classes", binding = LiteralStringBinding.class)
  public String getRes_outClasses() { 
    return res_outclasses;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outaggregateclasses;

  @LiteralDataInput(identifier = "outAggregateClasses", abstrakt = "The map with the geomorphological classes", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutAggregateClasses(String outaggregateclasses) { 
    this.outaggregateclasses = outaggregateclasses;
  }

  private String res_outaggregateclasses;

  @LiteralDataOutput(identifier = "res_outAggregateClasses", abstrakt = "The map with the geomorphological classes", binding = LiteralStringBinding.class)
  public String getRes_outAggregateClasses() { 
    return res_outaggregateclasses;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.GcAlgorithm");
    
    Gc tmpModule = new Gc(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("outClasses",  (String) outclasses); 
    logger.info("outClasses " + ( (String) outclasses) );
    inputs.put("pTh",  (int) pth); 
    logger.info("pTh " + ( (int) pth) );
    inputs.put("inSlope",  (String) inslope); 
    logger.info("inSlope " + ( (String) inslope) );
    inputs.put("inNetwork",  (String) innetwork); 
    logger.info("inNetwork " + ( (String) innetwork) );
    inputs.put("outAggregateClasses",  (String) outaggregateclasses); 
    logger.info("outAggregateClasses " + ( (String) outaggregateclasses) );
    inputs.put("inCp9",  (String) incp9); 
    logger.info("inCp9 " + ( (String) incp9) );
    
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
    
    outputs.put("outClasses", "String"); 
    outputs.put("outAggregateClasses", "String"); 
    
    res_outclasses = (String) outclasses; 
    res_outaggregateclasses = (String) outaggregateclasses; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outClasses")) { 
            // and put them into the output result variables 
            res_outclasses = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outAggregateClasses")) { 
            // and put them into the output result variables 
            res_outaggregateclasses = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

