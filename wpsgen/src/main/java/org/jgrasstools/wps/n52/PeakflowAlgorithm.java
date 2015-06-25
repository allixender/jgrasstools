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
import org.jgrasstools.modules.Peakflow; 
 
@Algorithm(version = "1.0.0", abstrakt = "The OmsPeakflow semidistributed hydrologic model.")
public class PeakflowAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(PeakflowAlgorithm.class); 

  public PeakflowAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = mm/h^m
  private double pa;

  @LiteralDataInput(identifier = "pA", abstrakt = "The a parameter for statistic rain calculations.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpA(double pa) { 
    this.pa = pa;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double pn;

  @LiteralDataInput(identifier = "pN", abstrakt = "The n parameter for statistic rain calculations.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpN(double pn) { 
    this.pn = pn;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = m/s
  private double pcelerity;

  @LiteralDataInput(identifier = "pCelerity", abstrakt = "The channel celerity parameter.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpCelerity(double pcelerity) { 
    this.pcelerity = pcelerity;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = m2/s
  private double pdiffusion;

  @LiteralDataInput(identifier = "pDiffusion", abstrakt = "The diffusion parameter.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpDiffusion(double pdiffusion) { 
    this.pdiffusion = pdiffusion;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = %
  private double psat;

  @LiteralDataInput(identifier = "pSat", abstrakt = "The saturation percentage.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpSat(double psat) { 
    this.psat = psat;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String intopindex;

  @LiteralDataInput(identifier = "inTopindex", abstrakt = "The map of Topindex.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinTopindex(String intopindex) { 
    this.intopindex = intopindex;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String insat;

  @LiteralDataInput(identifier = "inSat", abstrakt = "Optional map of saturation.", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinSat(String insat) { 
    this.insat = insat;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inrescaledsup;

  @LiteralDataInput(identifier = "inRescaledsup", abstrakt = "The map of superficial rescaled distance.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinRescaledsup(String inrescaledsup) { 
    this.inrescaledsup = inrescaledsup;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inrescaledsub;

  @LiteralDataInput(identifier = "inRescaledsub", abstrakt = "The map of sub-superficial rescaled distance.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinRescaledsub(String inrescaledsub) { 
    this.inrescaledsub = inrescaledsub;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inrainfall;

  @LiteralDataInput(identifier = "inRainfall", abstrakt = "The oms csv of rainfall data per timestep.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinRainfall(String inrainfall) { 
    this.inrainfall = inrainfall;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outdischarge;

  @LiteralDataInput(identifier = "outDischarge", abstrakt = "The oms csv of peakflow output per timestep.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutDischarge(String outdischarge) { 
    this.outdischarge = outdischarge;
  }

  private String res_outdischarge;

  @LiteralDataOutput(identifier = "res_outDischarge", abstrakt = "The oms csv of peakflow output per timestep.", binding = LiteralStringBinding.class)
  public String getRes_outDischarge() { 
    return res_outdischarge;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.PeakflowAlgorithm");
    
    Peakflow tmpModule = new Peakflow(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("pDiffusion",  (double) pdiffusion); 
    logger.info("pDiffusion " + ( (double) pdiffusion) );
    inputs.put("inRescaledsup",  (String) inrescaledsup); 
    logger.info("inRescaledsup " + ( (String) inrescaledsup) );
    inputs.put("inRescaledsub",  (String) inrescaledsub); 
    logger.info("inRescaledsub " + ( (String) inrescaledsub) );
    inputs.put("pCelerity",  (double) pcelerity); 
    logger.info("pCelerity " + ( (double) pcelerity) );
    inputs.put("outDischarge",  (String) outdischarge); 
    logger.info("outDischarge " + ( (String) outdischarge) );
    inputs.put("inTopindex",  (String) intopindex); 
    logger.info("inTopindex " + ( (String) intopindex) );
    inputs.put("pA",  (double) pa); 
    logger.info("pA " + ( (double) pa) );
    inputs.put("pN",  (double) pn); 
    logger.info("pN " + ( (double) pn) );
    inputs.put("inSat",  (String) insat); 
    logger.info("inSat " + ( (String) insat) );
    inputs.put("pSat",  (double) psat); 
    logger.info("pSat " + ( (double) psat) );
    inputs.put("inRainfall",  (String) inrainfall); 
    logger.info("inRainfall " + ( (String) inrainfall) );
    
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
    
    outputs.put("outDischarge", "String"); 
    
    res_outdischarge = (String) outdischarge; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outDischarge")) { 
            // and put them into the output result variables 
            res_outdischarge = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

