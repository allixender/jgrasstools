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
import org.jgrasstools.modules.IntersectionFinder; 
 
@Algorithm(version = "1.0.0", abstrakt = "Finds intersection geometries in feature collections")
public class IntersectionFinderAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(IntersectionFinderAlgorithm.class); 

  public IntersectionFinderAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inmap;

  @LiteralDataInput(identifier = "inMap", abstrakt = "The map to test for intersections.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinMap(String inmap) { 
    this.inmap = inmap;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outpointsmap;

  @LiteralDataInput(identifier = "outPointsMap", abstrakt = "The intersections points map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutPointsMap(String outpointsmap) { 
    this.outpointsmap = outpointsmap;
  }

  private String res_outpointsmap;

  @LiteralDataOutput(identifier = "res_outPointsMap", abstrakt = "The intersections points map.", binding = LiteralStringBinding.class)
  public String getRes_outPointsMap() { 
    return res_outpointsmap;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outlinesmap;

  @LiteralDataInput(identifier = "outLinesMap", abstrakt = "The intersections lines map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutLinesMap(String outlinesmap) { 
    this.outlinesmap = outlinesmap;
  }

  private String res_outlinesmap;

  @LiteralDataOutput(identifier = "res_outLinesMap", abstrakt = "The intersections lines map.", binding = LiteralStringBinding.class)
  public String getRes_outLinesMap() { 
    return res_outlinesmap;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.IntersectionFinderAlgorithm");
    
    IntersectionFinder tmpModule = new IntersectionFinder(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("outLinesMap",  (String) outlinesmap); 
    logger.info("outLinesMap " + ( (String) outlinesmap) );
    inputs.put("inMap",  (String) inmap); 
    logger.info("inMap " + ( (String) inmap) );
    inputs.put("outPointsMap",  (String) outpointsmap); 
    logger.info("outPointsMap " + ( (String) outpointsmap) );
    
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
    
    outputs.put("outLinesMap", "String"); 
    outputs.put("outPointsMap", "String"); 
    
    res_outlinesmap = (String) outlinesmap; 
    res_outpointsmap = (String) outpointsmap; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outLinesMap")) { 
            // and put them into the output result variables 
            res_outlinesmap = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outPointsMap")) { 
            // and put them into the output result variables 
            res_outpointsmap = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

