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
import org.jgrasstools.modules.PresteyTaylorEtpModel; 
 
@Algorithm(version = "1.0.0", abstrakt = "Calculates evapotranspiration based on the Prestey-Taylor model.")
public class PresteyTaylorEtpModelAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(PresteyTaylorEtpModelAlgorithm.class); 

  public PresteyTaylorEtpModelAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
    // uom = Watt m-2 
  private String innetradiation;

  @LiteralDataInput(identifier = "inNetradiation", abstrakt = "The net Radiation at the grass surface in W/m2 for the current hour.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinNetradiation(String innetradiation) { 
    this.innetradiation = innetradiation;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = Watt m-2
  private double defaultdailynetradiation;

  @LiteralDataInput(identifier = "defaultDailyNetradiation", abstrakt = "The daily net Radiation default value in case of missing data.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setdefaultDailyNetradiation(double defaultdailynetradiation) { 
    this.defaultdailynetradiation = defaultdailynetradiation;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = Watt m-2
  private double defaulthourlynetradiation;

  @LiteralDataInput(identifier = "defaultHourlyNetradiation", abstrakt = "The hourly net Radiation default value in case of missing data.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setdefaultHourlyNetradiation(double defaulthourlynetradiation) { 
    this.defaulthourlynetradiation = defaulthourlynetradiation;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean dohourly;

  @LiteralDataInput(identifier = "doHourly", abstrakt = "Switch that defines if it is hourly.", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoHourly(Boolean dohourly) { 
    this.dohourly = dohourly;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String fdataid;

  @LiteralDataInput(identifier = "fDataID", abstrakt = "The common id name for the data reading.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setfDataID(String fdataid) { 
    this.fdataid = fdataid;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
    // uom = C
  private String intemp;

  @LiteralDataInput(identifier = "inTemp", abstrakt = "The mean hourly air temperature.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinTemp(String intemp) { 
    this.intemp = intemp;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = m
  private double palpha;

  @LiteralDataInput(identifier = "pAlpha", abstrakt = "The alpha.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpAlpha(double palpha) { 
    this.palpha = palpha;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double pgmorn;

  @LiteralDataInput(identifier = "pGmorn", abstrakt = "The g morning.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpGmorn(double pgmorn) { 
    this.pgmorn = pgmorn;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double pgnight;

  @LiteralDataInput(identifier = "pGnight", abstrakt = "The g nigth.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpGnight(double pgnight) { 
    this.pgnight = pgnight;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = C
  private double defaulttemp;

  @LiteralDataInput(identifier = "defaultTemp", abstrakt = "The temperature default value in case of missing data.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setdefaultTemp(double defaulttemp) { 
    this.defaulttemp = defaulttemp;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
    // uom = KPa
  private String inpressure;

  @LiteralDataInput(identifier = "inPressure", abstrakt = "The atmospheric pressure in KPa.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinPressure(String inpressure) { 
    this.inpressure = inpressure;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = KPa
  private double defaultpressure;

  @LiteralDataInput(identifier = "defaultPressure", abstrakt = "The pressure default value in case of missing data.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setdefaultPressure(double defaultpressure) { 
    this.defaultpressure = defaultpressure;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
    // uom = mm hour-1
  private String outptetp;

  @LiteralDataInput(identifier = "outPTEtp", abstrakt = "The reference evapotranspiration.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutPTEtp(String outptetp) { 
    this.outptetp = outptetp;
  }

  private String res_outptetp;

  @LiteralDataOutput(identifier = "res_outPTEtp", abstrakt = "The reference evapotranspiration.", binding = LiteralStringBinding.class)
  public String getRes_outPTEtp() { 
    return res_outptetp;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.PresteyTaylorEtpModelAlgorithm");
    
    PresteyTaylorEtpModel tmpModule = new PresteyTaylorEtpModel(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("defaultDailyNetradiation",  (double) defaultdailynetradiation); 
    logger.info("defaultDailyNetradiation " + ( (double) defaultdailynetradiation) );
    inputs.put("inPressure",  (String) inpressure); 
    logger.info("inPressure " + ( (String) inpressure) );
    inputs.put("fDataID",  (String) fdataid); 
    logger.info("fDataID " + ( (String) fdataid) );
    inputs.put("defaultTemp",  (double) defaulttemp); 
    logger.info("defaultTemp " + ( (double) defaulttemp) );
    inputs.put("defaultHourlyNetradiation",  (double) defaulthourlynetradiation); 
    logger.info("defaultHourlyNetradiation " + ( (double) defaulthourlynetradiation) );
    inputs.put("pGnight",  (double) pgnight); 
    logger.info("pGnight " + ( (double) pgnight) );
    inputs.put("outPTEtp",  (String) outptetp); 
    logger.info("outPTEtp " + ( (String) outptetp) );
    inputs.put("doHourly",  (Boolean) dohourly); 
    logger.info("doHourly " + ( (Boolean) dohourly) );
    inputs.put("inNetradiation",  (String) innetradiation); 
    logger.info("inNetradiation " + ( (String) innetradiation) );
    inputs.put("pGmorn",  (double) pgmorn); 
    logger.info("pGmorn " + ( (double) pgmorn) );
    inputs.put("inTemp",  (String) intemp); 
    logger.info("inTemp " + ( (String) intemp) );
    inputs.put("pAlpha",  (double) palpha); 
    logger.info("pAlpha " + ( (double) palpha) );
    inputs.put("defaultPressure",  (double) defaultpressure); 
    logger.info("defaultPressure " + ( (double) defaultpressure) );
    
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
    
    outputs.put("outPTEtp", "String"); 
    
    res_outptetp = (String) outptetp; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outPTEtp")) { 
            // and put them into the output result variables 
            res_outptetp = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

