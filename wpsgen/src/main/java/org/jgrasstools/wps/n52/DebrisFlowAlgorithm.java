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
import org.jgrasstools.modules.DebrisFlow; 
 
@Algorithm(version = "1.0.0", abstrakt = "Debris flow area and deposit calculator on fans.")
public class DebrisFlowAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(DebrisFlowAlgorithm.class); 

  public DebrisFlowAlgorithm() { 
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
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = m2
  private double pvolume;

  @LiteralDataInput(identifier = "pVolume", abstrakt = "The volume of the event to simulate.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpVolume(double pvolume) { 
    this.pvolume = pvolume;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = -
  private double pmcoeff;

  @LiteralDataInput(identifier = "pMcoeff", abstrakt = "The mobility coefficient", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpMcoeff(double pmcoeff) { 
    this.pmcoeff = pmcoeff;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = -
  private double pdcoeff;

  @LiteralDataInput(identifier = "pDcoeff", abstrakt = "The deposit coefficient", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpDcoeff(double pdcoeff) { 
    this.pdcoeff = pdcoeff;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = m
  private double peasting;

  @LiteralDataInput(identifier = "pEasting", abstrakt = "The start position of the simulation (easting)", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpEasting(double peasting) { 
    this.peasting = peasting;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = m
  private double pnorthing;

  @LiteralDataInput(identifier = "pNorthing", abstrakt = "The start position of the simulation (northing)", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpNorthing(double pnorthing) { 
    this.pnorthing = pnorthing;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int pmontecarlo;

  @LiteralDataInput(identifier = "pMontecarlo", abstrakt = "The Montecarlo number.", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpMontecarlo(int pmontecarlo) { 
    this.pmontecarlo = pmontecarlo;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outmcs;

  @LiteralDataInput(identifier = "outMcs", abstrakt = "The output inundation map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutMcs(String outmcs) { 
    this.outmcs = outmcs;
  }

  private String res_outmcs;

  @LiteralDataOutput(identifier = "res_outMcs", abstrakt = "The output inundation map.", binding = LiteralStringBinding.class)
  public String getRes_outMcs() { 
    return res_outmcs;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outdepo;

  @LiteralDataInput(identifier = "outDepo", abstrakt = "The output deposit map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutDepo(String outdepo) { 
    this.outdepo = outdepo;
  }

  private String res_outdepo;

  @LiteralDataOutput(identifier = "res_outDepo", abstrakt = "The output deposit map.", binding = LiteralStringBinding.class)
  public String getRes_outDepo() { 
    return res_outdepo;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.DebrisFlowAlgorithm");
    
    DebrisFlow tmpModule = new DebrisFlow(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("pVolume",  (double) pvolume); 
    logger.info("pVolume " + ( (double) pvolume) );
    inputs.put("pMcoeff",  (double) pmcoeff); 
    logger.info("pMcoeff " + ( (double) pmcoeff) );
    inputs.put("inElev",  (String) inelev); 
    logger.info("inElev " + ( (String) inelev) );
    inputs.put("outMcs",  (String) outmcs); 
    logger.info("outMcs " + ( (String) outmcs) );
    inputs.put("outDepo",  (String) outdepo); 
    logger.info("outDepo " + ( (String) outdepo) );
    inputs.put("pNorthing",  (double) pnorthing); 
    logger.info("pNorthing " + ( (double) pnorthing) );
    inputs.put("pMontecarlo",  (int) pmontecarlo); 
    logger.info("pMontecarlo " + ( (int) pmontecarlo) );
    inputs.put("pDcoeff",  (double) pdcoeff); 
    logger.info("pDcoeff " + ( (double) pdcoeff) );
    inputs.put("pEasting",  (double) peasting); 
    logger.info("pEasting " + ( (double) peasting) );
    
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
    
    outputs.put("outMcs", "String"); 
    outputs.put("outDepo", "String"); 
    
    res_outmcs = (String) outmcs; 
    res_outdepo = (String) outdepo; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outMcs")) { 
            // and put them into the output result variables 
            res_outmcs = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outDepo")) { 
            // and put them into the output result variables 
            res_outdepo = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

