package com.dudelson.brickhack15.know2.dict;

/** Encapsulates all the phonemes used in the dictionary */
public class Phoneme {
	// constants for each phoneme
	public static final String PHONEME_AA = "AA";
	public static final String PHONEME_AA0 = "AA0";
	public static final String PHONEME_AA1 = "AA1";
	public static final String PHONEME_AA2 = "AA2";
	public static final String PHONEME_AE = "AE";
	public static final String PHONEME_AE0 = "AE0";
	public static final String PHONEME_AE1 = "AE1";
	public static final String PHONEME_AE2 = "AE2";
	public static final String PHONEME_AH = "AH";
	public static final String PHONEME_AH0 = "AH0";
	public static final String PHONEME_AH1 = "AH1";
	public static final String PHONEME_AH2 = "AH2";
	public static final String PHONEME_AO = "AO";
	public static final String PHONEME_AO0 = "AO0";
	public static final String PHONEME_AO1 = "AO1";
	public static final String PHONEME_AO2 = "AO2";
    public static final String PHONEME_AW = "AW";
	public static final String PHONEME_AW0 = "AW0";
	public static final String PHONEME_AW1 = "AW1";
	public static final String PHONEME_AW2 = "AW2";
	public static final String PHONEME_AY = "AY";
	public static final String PHONEME_AY0 = "AY0";
	public static final String PHONEME_AY1 = "AY1";
	public static final String PHONEME_AY2 = "AY2";
	public static final String PHONEME_B = "B";
	public static final String PHONEME_CH = "CH";
	public static final String PHONEME_D = "D";
	public static final String PHONEME_DH = "DH";
	public static final String PHONEME_EH = "EH";
	public static final String PHONEME_EH0 = "EH0";
	public static final String PHONEME_EH1 = "EH1";
	public static final String PHONEME_EH2E = "H2";
	public static final String PHONEME_ER = "ER";
	public static final String PHONEME_ER0 = "ER0";
	public static final String PHONEME_ER1 = "ER1";
	public static final String PHONEME_ER2 = "ER2";
	public static final String PHONEME_EY = "EY";
	public static final String PHONEME_EY0 = "EY0";
	public static final String PHONEME_EY1 = "EY1";
	public static final String PHONEME_EY2 = "EY2";
	public static final String PHONEME_F = "F";
	public static final String PHONEME_G = "G";
	public static final String PHONEME_HH = "HH";
	public static final String PHONEME_IH = "IH";
	public static final String PHONEME_IH0 = "IH0";
	public static final String PHONEME_IH1 = "IH1";
	public static final String PHONEME_IH2 = "IH2";
	public static final String PHONEME_IY = "IY";
	public static final String PHONEME_IY0 = "IY0";
	public static final String PHONEME_IY1 = "IY1";
	public static final String PHONEME_IY2 = "IY2";
	public static final String PHONEME_JH = "JH";
	public static final String PHONEME_K = "K";
	public static final String PHONEME_L = "L";
	public static final String PHONEME_M = "M";
	public static final String PHONEME_N = "N";
	public static final String PHONEME_NG = "NG";
	public static final String PHONEME_OW = "OW";
	public static final String PHONEME_OW0 = "OW0";
	public static final String PHONEME_OW1 = "OW1";
	public static final String PHONEME_OW2 = "OW2";
	public static final String PHONEME_OY = "OY";
	public static final String PHONEME_OY0 = "OY0";
	public static final String PHONEME_OY1 = "OY1";
	public static final String PHONEME_OY2 = "OY2";
	public static final String PHONEME_P = "P";
	public static final String PHONEME_R = "R";
	public static final String PHONEME_S = "S";
	public static final String PHONEME_SH = "SH";
	public static final String PHONEME_T = "T";
	public static final String PHONEME_TH = "TH";
	public static final String PHONEME_UH = "UH";
	public static final String PHONEME_UH0 = "UH0";
	public static final String PHONEME_UH1 = "UH1";
	public static final String PHONEME_UH2 = "UH2";
	public static final String PHONEME_UW = "UW";
	public static final String PHONEME_UW0 = "UW0";
	public static final String PHONEME_UW1 = "UW1";
	public static final String PHONEME_UW2 = "UW2";
	public static final String PHONEME_V = "V";
	public static final String PHONEME_W = "W";
	public static final String PHONEME_Y = "Y";
	public static final String PHONEME_Z = "Z";
	public static final String PHONEME_ZH = "ZH";
	
	public static final String[] PHONEMES = {PHONEME_AA , PHONEME_AA0 , PHONEME_AA1 ,
	PHONEME_AA2 , PHONEME_AE , PHONEME_AE0 , PHONEME_AE1 , PHONEME_AE2 , PHONEME_AH ,
	PHONEME_AH0 , PHONEME_AH1 , PHONEME_AH2 , PHONEME_AO , PHONEME_AO0 , PHONEME_AO1 ,
	PHONEME_AO2 , PHONEME_AW , PHONEME_AW0 , PHONEME_AW1 , PHONEME_AW2 , PHONEME_AY ,
	PHONEME_AY0 , PHONEME_AY1 , PHONEME_AY2 , PHONEME_B , PHONEME_CH , PHONEME_D ,
	PHONEME_DH , PHONEME_EH , PHONEME_EH0 , PHONEME_EH1 , PHONEME_EH2E , PHONEME_ER , PHONEME_ER0, PHONEME_ER1,
	PHONEME_ER2 , PHONEME_EY , PHONEME_EY0 , PHONEME_EY1 , PHONEME_EY2 , PHONEME_F ,
	PHONEME_G , PHONEME_HH , PHONEME_IH , PHONEME_IH0 , PHONEME_IH1 , PHONEME_IH2 ,
	PHONEME_IY , PHONEME_IY0 , PHONEME_IY1 , PHONEME_IY2 , PHONEME_JH , PHONEME_K ,
	PHONEME_L , PHONEME_M , PHONEME_N , PHONEME_NG , PHONEME_OW , PHONEME_OW0 ,
	PHONEME_OW1 , PHONEME_OW2 , PHONEME_OY , PHONEME_OY0 , PHONEME_OY1 , PHONEME_OY2 ,
	PHONEME_P , PHONEME_R , PHONEME_S , PHONEME_SH , PHONEME_T , PHONEME_TH ,
	PHONEME_UH , PHONEME_UH0 , PHONEME_UH1 , PHONEME_UH2 , PHONEME_UW , PHONEME_UW0 ,
	PHONEME_UW1 , PHONEME_UW2 , PHONEME_V , PHONEME_W , PHONEME_Y , PHONEME_Z , PHONEME_ZH };

}
