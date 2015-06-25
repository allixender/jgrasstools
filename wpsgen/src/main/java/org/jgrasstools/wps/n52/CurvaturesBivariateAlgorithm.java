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
import org.jgrasstools.modules.CurvaturesBivariate; 
 
@Algorithm(version = "1.0.0", abstrakt = "Estimates the longitudinal, normal and planar curvatures by means of a bivariate quadratic representation of the terrain.")
public class CurvaturesBivariateAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(CurvaturesBivariateAlgorithm.class); 

  public CurvaturesBivariateAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inelev;

  @LiteralDataInput(identifier = "inElev", abstrakt = "The map of the digital elevation model (DEM or pit).", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinElev(String inelev) { 
    this.inelev = inelev;
  }

    // inputOutputIndicator = output
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String res_outprof;

  @LiteralDataOutput(identifier = "res_outProf", abstrakt = "The map of profile curvatures.", binding = LiteralStringBinding.class)
  public String getRes_outProf() { 
    return res_outprof;
  }

    // inputOutputIndicator = output
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String res_outplan;

  @LiteralDataOutput(identifier = "res_outPlan", abstrakt = "The map of planar curvatures.", binding = LiteralStringBinding.class)
  public String getRes_outPlan() { 
    return res_outplan;
  }

    // inputOutputIndicator = output
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String res_outslope;

  @LiteralDataOutput(identifier = "res_outSlope", abstrakt = "The map of slope.", binding = LiteralStringBinding.class)
  public String getRes_outSlope() { 
    return res_outslope;
  }

    // inputOutputIndicator = output
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String res_outaspect;

  @LiteralDataOutput(identifier = "res_outAspect", abstrakt = "The map of aspect", binding = LiteralStringBinding.class)
  public String getRes_outAspect() { 
    return res_outaspect;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int pcells;

  @LiteralDataInput(identifier = "pCells", abstrakt = "The size of the analysis window in odd cells number.", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpCells(int pcells) { 
    this.pcells = pcells;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.CurvaturesBivariateAlgorithm");
    
    CurvaturesBivariate tmpModule = new CurvaturesBivariate(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("inElev",  (String) inelev); 
    logger.info("inElev " + ( (String) inelev) );
    inputs.put("pCells",  (int) pcells); 
    logger.info("pCells " + ( (int) pcells) );
    
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
    
    outputs.put("outSlope", "String"); 
    outputs.put("outProf", "String"); 
    outputs.put("outAspect", "String"); 
    outputs.put("outPlan", "String"); 
    
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outSlope")) { 
            // and put them into the output result variables 
            res_outslope = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outProf")) { 
            // and put them into the output result variables 
            res_outprof = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outAspect")) { 
            // and put them into the output result variables 
            res_outaspect = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outPlan")) { 
            // and put them into the output result variables 
            res_outplan = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

