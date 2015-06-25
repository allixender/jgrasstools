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
import org.jgrasstools.modules.Tc; 
 
@Algorithm(version = "1.0.0", abstrakt = "Subdivides the sites of a basin in the 9 topographic classes identified by the longitudinal and transversal curvatures. ")
public class TcAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(TcAlgorithm.class); 

  public TcAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inprof;

  @LiteralDataInput(identifier = "inProf", abstrakt = "The longitudinal curvatures raster.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinProf(String inprof) { 
    this.inprof = inprof;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String intan;

  @LiteralDataInput(identifier = "inTan", abstrakt = "The normal curvatures raster.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinTan(String intan) { 
    this.intan = intan;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double pprofthres;

  @LiteralDataInput(identifier = "pProfthres", abstrakt = "The threshold value for the longitudinal curvatures.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpProfthres(double pprofthres) { 
    this.pprofthres = pprofthres;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double ptanthres;

  @LiteralDataInput(identifier = "pTanthres", abstrakt = "The threshold value for the normal curvaturess.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpTanthres(double ptanthres) { 
    this.ptanthres = ptanthres;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outtc9;

  @LiteralDataInput(identifier = "outTc9", abstrakt = "The map of 9 topographic classes.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutTc9(String outtc9) { 
    this.outtc9 = outtc9;
  }

  private String res_outtc9;

  @LiteralDataOutput(identifier = "res_outTc9", abstrakt = "The map of 9 topographic classes.", binding = LiteralStringBinding.class)
  public String getRes_outTc9() { 
    return res_outtc9;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outtc3;

  @LiteralDataInput(identifier = "outTc3", abstrakt = "The map of 3 aggregated fundamental topographic classes.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutTc3(String outtc3) { 
    this.outtc3 = outtc3;
  }

  private String res_outtc3;

  @LiteralDataOutput(identifier = "res_outTc3", abstrakt = "The map of 3 aggregated fundamental topographic classes.", binding = LiteralStringBinding.class)
  public String getRes_outTc3() { 
    return res_outtc3;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.TcAlgorithm");
    
    Tc tmpModule = new Tc(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("pProfthres",  (double) pprofthres); 
    logger.info("pProfthres " + ( (double) pprofthres) );
    inputs.put("outTc9",  (String) outtc9); 
    logger.info("outTc9 " + ( (String) outtc9) );
    inputs.put("inTan",  (String) intan); 
    logger.info("inTan " + ( (String) intan) );
    inputs.put("outTc3",  (String) outtc3); 
    logger.info("outTc3 " + ( (String) outtc3) );
    inputs.put("pTanthres",  (double) ptanthres); 
    logger.info("pTanthres " + ( (double) ptanthres) );
    inputs.put("inProf",  (String) inprof); 
    logger.info("inProf " + ( (String) inprof) );
    
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
    
    outputs.put("outTc9", "String"); 
    outputs.put("outTc3", "String"); 
    
    res_outtc9 = (String) outtc9; 
    res_outtc3 = (String) outtc3; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outTc9")) { 
            // and put them into the output result variables 
            res_outtc9 = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outTc3")) { 
            // and put them into the output result variables 
            res_outtc3 = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

