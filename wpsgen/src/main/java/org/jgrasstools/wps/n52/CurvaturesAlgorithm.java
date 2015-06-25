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
import org.jgrasstools.modules.Curvatures; 
 
@Algorithm(version = "1.0.0", abstrakt = "It estimates the longitudinal, normal and planar curvatures.")
public class CurvaturesAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(CurvaturesAlgorithm.class); 

  public CurvaturesAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inelev;

  @LiteralDataInput(identifier = "inElev", abstrakt = "The map of the digital elevation model (DEM or pit).", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinElev(String inelev) { 
    this.inelev = inelev;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outprof;

  @LiteralDataInput(identifier = "outProf", abstrakt = "The map of profile curvatures.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutProf(String outprof) { 
    this.outprof = outprof;
  }

  private String res_outprof;

  @LiteralDataOutput(identifier = "res_outProf", abstrakt = "The map of profile curvatures.", binding = LiteralStringBinding.class)
  public String getRes_outProf() { 
    return res_outprof;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outplan;

  @LiteralDataInput(identifier = "outPlan", abstrakt = "The map of planar curvatures.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutPlan(String outplan) { 
    this.outplan = outplan;
  }

  private String res_outplan;

  @LiteralDataOutput(identifier = "res_outPlan", abstrakt = "The map of planar curvatures.", binding = LiteralStringBinding.class)
  public String getRes_outPlan() { 
    return res_outplan;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outtang;

  @LiteralDataInput(identifier = "outTang", abstrakt = "The map of tangential curvatures.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutTang(String outtang) { 
    this.outtang = outtang;
  }

  private String res_outtang;

  @LiteralDataOutput(identifier = "res_outTang", abstrakt = "The map of tangential curvatures.", binding = LiteralStringBinding.class)
  public String getRes_outTang() { 
    return res_outtang;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.CurvaturesAlgorithm");
    
    Curvatures tmpModule = new Curvatures(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("outProf",  (String) outprof); 
    logger.info("outProf " + ( (String) outprof) );
    inputs.put("inElev",  (String) inelev); 
    logger.info("inElev " + ( (String) inelev) );
    inputs.put("outPlan",  (String) outplan); 
    logger.info("outPlan " + ( (String) outplan) );
    inputs.put("outTang",  (String) outtang); 
    logger.info("outTang " + ( (String) outtang) );
    
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
    
    outputs.put("outProf", "String"); 
    outputs.put("outPlan", "String"); 
    outputs.put("outTang", "String"); 
    
    res_outprof = (String) outprof; 
    res_outplan = (String) outplan; 
    res_outtang = (String) outtang; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outProf")) { 
            // and put them into the output result variables 
            res_outprof = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outPlan")) { 
            // and put them into the output result variables 
            res_outplan = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outTang")) { 
            // and put them into the output result variables 
            res_outtang = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

