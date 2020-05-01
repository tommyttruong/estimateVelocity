package estimateVelocity;

import java.util.*;

public class dragFactor {
	
	public Map<String, Double> createMap() {
	
		Random random = new Random();
		
	    Map<String, Double> values = new HashMap<String, Double>();
	
	
	    double dcnlMin = 0.80;
	    double dcnlMax = 1.20;
	    double dcnlValue = dcnlMin + (dcnlMax - dcnlMin) * random.nextDouble();
	    values.put("dcnl", dcnlValue);
	
	
	    double dcnmMin = 0.70;
	    double dcnmMax = 1.00;
	    double dcnmValue = dcnmMin + (dcnmMax - dcnmMin) * random.nextDouble();
	    values.put("dcnm", dcnmValue);
	
	
	    double wcnlMin = 0.50;
	    double wcnlMax = 0.80;
	    double wcnlValue = wcnlMin + (wcnlMax - wcnlMin) * random.nextDouble();
	    values.put("wcnl", wcnlValue);
	
	
	    double wcnmMin = 0.40;
	    double wcnmMax = 0.75;
	    double wcnmValue = wcnmMin + (wcnmMax - wcnmMin) * random.nextDouble();
	    values.put("wcnm", wcnmValue);
	
	
	    //cement travelled ct
	    double dctlMin = 0.60;
	    double dctlMax = 0.80;
	    double dctlValue = dctlMin + (dctlMax - dctlMin) * random.nextDouble();
	    values.put("dctl", dctlValue);
	
	    double dctmMin = 0.60;
	    double dctmMax = 0.75;
	    double dctmValue = dctmMin + (dctmMax - dctmMin) * random.nextDouble();
	    values.put("dctm", dctmValue);
	
	    double wctlMin = 0.45;
	    double wctlMax = 0.70;
	    double wctlValue = wctlMin + (wctlMax - wctlMin) * random.nextDouble();
	    values.put("wctl", wctlValue);
	
	    double wctmMin = 0.45;
	    double wctmMax = 0.65;
	    double wctmValue = wctmMin + (wctmMax - wctmMin) * random.nextDouble();
	    values.put("wctm", wctmValue);
	
	    //cement polished cp
	    double dcplMin = 0.55;
	    double dcplMax = 0.75;
	    double dcplValue = dcplMin + (dcplMax - dcplMin) * random.nextDouble();
	    values.put("dcpl", dcplValue);
	
	    double dcpmMin = 0.50;
	    double dcpmMax = 0.65;
	    double dcpmValue = dcpmMin + (dcpmMax - dcpmMin) * random.nextDouble();
	    values.put("dcpm", dcpmValue);
	
	    double wcplMin = 0.45;
	    double wcplMax = 0.65;
	    double wcplValue = wcplMin + (wcplMax - wcplMin) * random.nextDouble();
	    values.put("wcpl", wcplValue);
	
	    double wcpmMin = 0.45;
	    double wcpmMax = 0.60;
	    double wcpmValue = wcpmMin + (wcpmMax - wcpmMin) * random.nextDouble();
	    values.put("wcpm", wcpmValue);
	
	    //asphalt new an
	    double danlMin = 0.80;
	    double danlMax = 1.20;
	    double danlValue = danlMin + (danlMax - danlMin) * random.nextDouble();
	    values.put("danl", danlValue);
	
	    double danmMin = 0.65;
	    double danmMax = 1.00;
	    double danmValue = danmMin + (danmMax - danmMin) * random.nextDouble();
	    values.put("danm", danmValue);
	
	    double wanlMin = 0.50;
	    double wanlMax = 0.80;
	    double wanlValue = wanlMin + (wanlMax - wanlMin) * random.nextDouble();
	    values.put("wanl", wanlValue);
	
	    double wanmMin = 0.45;
	    double wanmMax = 0.75;
	    double wanmValue = wanmMin + (wanmMax - wanmMin) * random.nextDouble();
	    values.put("wanm", wanmValue);
	
	    //asphalt travelled at
	     double datlMin = 0.60;
	     double datlMax = 0.80;
	     double datlValue = datlMin + (datlMax - datlMin) * random.nextDouble();
	    values.put("datl", datlValue);
	
	     double datmMin = 0.55;
	     double datmMax = 0.70;
	     double datmValue = datmMin + (datmMax - datmMin) * random.nextDouble();
	    values.put("datm", datmValue);
	
	     double watlMin = 0.45;
	     double watlMax = 0.70;
	     double watlValue = watlMin + (watlMax - watlMin) * random.nextDouble();
	    values.put("watl", watlValue);
	
	     double watmMin = 0.40;
	     double watmMax = 0.65;
	     double watmValue = watmMin + (watmMax - watmMin) * random.nextDouble();
	    values.put("watm", watmValue);
	
	    //asphalt polished ap
	     double daplMin = 0.55;
	     double daplMax = 0.75;
	     double daplValue = daplMin + (daplMax - daplMin) * random.nextDouble();
	    values.put("dapl", daplValue);
	
	     double dapmMin = 0.45;
	     double dapmMax = 0.65;
	     double dapmValue = dapmMin + (dapmMax - dapmMin) * random.nextDouble();
	    values.put("dapm", dapmValue);
	
	     double waplMin = 0.45;
	     double waplMax = 0.65;
	     double waplValue = waplMin + (waplMax - waplMin) * random.nextDouble();
	    values.put("wapl", waplValue);
	
	     double wapmMin = 0.40;
	     double wapmMax = 0.60;
	     double wapmValue = wapmMin + (wapmMax - wapmMin) * random.nextDouble();
	    values.put("wapm", wapmValue);
	
	    //asphalt excess tar ae
	     double daelMin = 0.50;
	     double daelMax = 0.60;
	     double daelValue = daelMin + (daelMax - daelMin) * random.nextDouble();
	    values.put("dael", daelValue);
	
	     double daemMin = 0.35;
	     double daemMax = 0.60;
	     double daemValue = daemMin + (daemMax - daemMin) * random.nextDouble();
	    values.put("daem", daemValue);
	
	     double waelMin = 0.30;
	     double waelMax = 0.60;
	     double waelValue = waelMin + (waelMax - waelMin) * random.nextDouble();
	    values.put("wael", waelValue);
	
	     double waemMin = 0.25;
	     double waemMax = 0.55;
	     double waemValue = waemMin + (waemMax - waemMin) * random.nextDouble();
	    values.put("waem", waemValue);
	
	    //gravel packed gp
	     double dgplMin = 0.55;
	     double dgplMax = 0.85;
	     double dgplValue = dgplMin + (dgplMax - dgplMin) * random.nextDouble();
	    values.put("dgpl", dgplValue);
	
	     double dgpmMin = 0.50;
	     double dgpmMax = 0.80;
	     double dgpmValue = dgpmMin + (dgpmMax - dgpmMin) * random.nextDouble();
	    values.put("dgpm", dgpmValue);
	
	     double wgplMin = 0.40;
	     double wgplMax = 0.80;
	     double wgplValue = wgplMin + (wgplMax - wgplMin) * random.nextDouble();
	    values.put("wgpl", wgplValue);
	
	     double wgpmMin = 0.40;
	     double wgpmMax = 0.60;
	     double wgpmValue = wgpmMin + (wgpmMax - wgpmMin) * random.nextDouble();
	    values.put("wgpm", wgpmValue);
	
	    //gravel loose gl
	     double dgllMin = 0.40;
	     double dgllMax = 0.70;
	     double dgllValue = dgllMin + (dgllMax - dgllMin) * random.nextDouble();
	    values.put("dgll", dgllValue);
	
	     double dglmMin = 0.40;
	     double dglmMax = 0.70;
	     double dglmValue = dglmMin + (dglmMax - dglmMin) * random.nextDouble();
	    values.put("dglm", dglmValue);
	
	     double wgllMin = 0.45;
	     double wgllMax = 0.75;
	     double wgllValue = wgllMin + (wgllMax - wgllMin) * random.nextDouble();
	    values.put("wgll", wgllValue);
	
	     double wglmMin = 0.45;
	     double wglmMax = 0.75;
	     double wglmValue = wglmMin + (wglmMax - wglmMin) * random.nextDouble();
	    values.put("wglm", wglmValue);
	
	    //cinder packed cip
	     double dciplMin = 0.50;
	     double dciplMax = 0.70;
	     double dciplValue = dciplMin + (dciplMax - dciplMin) * random.nextDouble();
	    values.put("dcipl", dciplValue);
	
	     double dcipmMin = 0.50;
	     double dcipmMax = 0.70;
	     double dcipmValue = dcipmMin + (dcipmMax - dcipmMin) * random.nextDouble();
	    values.put("dcipm", dcipmValue);
	
	     double wciplMin = 0.65;
	     double wciplMax = 0.75;
	     double wciplValue = wciplMin + (wciplMax - wciplMin) * random.nextDouble();
	    values.put("wcipl", wciplValue);
	
	     double wcipmMin = 0.65;
	     double wcipmMax = 0.75;
	     double wcipmValue = wcipmMin + (wcipmMax - wcipmMin) * random.nextDouble();
	    values.put("wcipm", wcipmValue);
	
	    //rock crushed rc
	     double drclMin = 0.55;
	     double drclMax = 0.75;
	     double drclValue = drclMin + (drclMax - drclMin) * random.nextDouble();
	    values.put("drcl", drclValue);
	
	     double drcmMin = 0.55;
	     double drcmMax = 0.75;
	     double drcmValue = drcmMin + (drcmMax - drcmMin) * random.nextDouble();
	    values.put("drcm", drcmValue);
	
	     double wrclMin = 0.55;
	     double wrclMax = 0.75;
	     double wrclValue = wrclMin + (wrclMax - wrclMin) * random.nextDouble();
	    values.put("wrcl", wrclValue);
	
	     double wrcmMin = 0.55;
	     double wrcmMax = 0.75;
	     double wrcmValue = wrcmMin + (wrcmMax - wrcmMin) * random.nextDouble();
	    values.put("wrcm", wrcmValue);
	
	    //ice smooth is
	     double dislMin = 0.10;
	     double dislMax = 0.25;
	     double dislValue = dislMin + (dislMax - dislMin) * random.nextDouble();
	    values.put("disl", dislValue);
	
	     double dismMin = 0.07;
	     double dismMax = 0.20;
	     double dismValue = dismMin + (dismMax - dismMin) * random.nextDouble();
	    values.put("dism", dismValue);
	
	     double wislMin = 0.05;
	     double wislMax = 0.10;
	     double wislValue = wislMin + (wislMax - wislMin) * random.nextDouble();
	    values.put("wisl", wislValue);
	
	     double wismMin = 0.05;
	     double wismMax = 0.10;
	     double wismValue = wismMin + (wismMax - wismMin) * random.nextDouble();
	    values.put("wism", wismValue);
	
	    //snow packed sp
	     double dsplMin = 0.30;
	     double dsplMax = 0.55;
	     double dsplValue = dsplMin + (dsplMax - dsplMin) * random.nextDouble();
	    values.put("dspl", dsplValue);
	
	     double dspmMin = 0.35;
	     double dspmMax = 0.55;
	     double dspmValue = dspmMin + (dspmMax - dspmMin) * random.nextDouble();
	    values.put("dspm", dspmValue);
	
	     double wsplMin = 0.30;
	     double wsplMax = 0.60;
	     double wsplValue = wsplMin + (wsplMax - wsplMin) * random.nextDouble();
	    values.put("wspl", wsplValue);
	
	     double wspmMin = 0.30;
	     double wspmMax = 0.60;
	     double wspmValue = wspmMin + (wspmMax - wspmMin) * random.nextDouble();
	    values.put("wspm", wspmValue);
	
	    //snow loose sl
	     double dsllMin = 0.10;
	     double dsllMax = 0.25;
	     double dsllValue = dsllMin + (dsllMax - dsllMin) * random.nextDouble();
	    values.put("dsll", dsllValue);
	
	     double dslmMin = 0.10;
	     double dslmMax = 0.20;
	     double dslmValue = dslmMin + (dslmMax - dslmMin) * random.nextDouble();
	    values.put("dslm", dslmValue);
	
	     double wsllMin = 0.30;
	     double wsllMax = 0.60;
	     double wsllValue = wsllMin + (wsllMax - wsllMin) * random.nextDouble();
	    values.put("wsll", wsllValue);
	
	     double wslmMin = 0.30;
	     double wslmMax = 0.60;
	     double wslmValue = wslmMin + (wslmMax - wslmMin) * random.nextDouble();
	    values.put("wslm", wslmValue);
	    
	    return values;
	
	}
    


}
