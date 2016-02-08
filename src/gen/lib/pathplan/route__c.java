/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * (C) Copyright 2009-2017, Arnaud Roques
 *
 * Project Info:  http://plantuml.com
 * 
 * This file is part of PlantUML.
 *
 * PlantUML is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PlantUML distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 *
 * Original Author:  Arnaud Roques
 *
 *
 *
 *
 *************************************************************************
 * Copyright (c) 2011 AT&T Intellectual Property 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: See CVS logs. Details at http://www.graphviz.org/
 *************************************************************************
 *
 */
package gen.lib.pathplan;
import h.*;
import smetana.core.*;
import static smetana.core.Macro.*;
import static smetana.core.JUtils.*;
import static gen.lib.cdt.dtclose__c.*;
import static gen.lib.cdt.dtdisc__c.*;
import static gen.lib.cdt.dtextract__c.*;
import static gen.lib.cdt.dtflatten__c.*;
import static gen.lib.cdt.dthash__c.*;
import static gen.lib.cdt.dtlist__c.*;
import static gen.lib.cdt.dtmethod__c.*;
import static gen.lib.cdt.dtopen__c.*;
import static gen.lib.cdt.dtrenew__c.*;
import static gen.lib.cdt.dtrestore__c.*;
import static gen.lib.cdt.dtsize__c.*;
import static gen.lib.cdt.dtstat__c.*;
import static gen.lib.cdt.dtstrhash__c.*;
import static gen.lib.cdt.dttreeset__c.*;
import static gen.lib.cdt.dttree__c.*;
import static gen.lib.cdt.dtview__c.*;
import static gen.lib.cdt.dtwalk__c.*;
import static gen.lib.cgraph.agerror__c.*;
import static gen.lib.cgraph.agxbuf__c.*;
import static gen.lib.cgraph.apply__c.*;
import static gen.lib.cgraph.attr__c.*;
import static gen.lib.cgraph.cmpnd__c.*;
import static gen.lib.cgraph.edge__c.*;
import static gen.lib.cgraph.flatten__c.*;
import static gen.lib.cgraph.grammar__c.*;
import static gen.lib.cgraph.graph__c.*;
import static gen.lib.cgraph.id__c.*;
import static gen.lib.cgraph.imap__c.*;
import static gen.lib.cgraph.io__c.*;
import static gen.lib.cgraph.main__c.*;
import static gen.lib.cgraph.mem__c.*;
import static gen.lib.cgraph.node__c.*;
import static gen.lib.cgraph.obj__c.*;
import static gen.lib.cgraph.pend__c.*;
import static gen.lib.cgraph.rec__c.*;
import static gen.lib.cgraph.refstr__c.*;
import static gen.lib.cgraph.scan__c.*;
import static gen.lib.cgraph.subg__c.*;
import static gen.lib.cgraph.tester__c.*;
import static gen.lib.cgraph.utils__c.*;
import static gen.lib.cgraph.write__c.*;
import static gen.lib.cgraph.y_tab__c.*;
import static gen.lib.circogen.blockpath__c.*;
import static gen.lib.circogen.blocktree__c.*;
import static gen.lib.circogen.block__c.*;
import static gen.lib.circogen.circpos__c.*;
import static gen.lib.circogen.circularinit__c.*;
import static gen.lib.circogen.circular__c.*;
import static gen.lib.circogen.deglist__c.*;
import static gen.lib.circogen.edgelist__c.*;
import static gen.lib.circogen.nodelist__c.*;
import static gen.lib.circogen.nodeset__c.*;
import static gen.lib.common.args__c.*;
import static gen.lib.common.arrows__c.*;
import static gen.lib.common.colxlate__c.*;
import static gen.lib.common.ellipse__c.*;
import static gen.lib.common.emit__c.*;
import static gen.lib.common.geom__c.*;
import static gen.lib.common.globals__c.*;
import static gen.lib.common.htmllex__c.*;
import static gen.lib.common.htmlparse__c.*;
import static gen.lib.common.htmltable__c.*;
import static gen.lib.common.input__c.*;
import static gen.lib.common.intset__c.*;
import static gen.lib.common.labels__c.*;
import static gen.lib.common.memory__c.*;
import static gen.lib.common.ns__c.*;
import static gen.lib.common.output__c.*;
import static gen.lib.common.pointset__c.*;
import static gen.lib.common.postproc__c.*;
import static gen.lib.common.psusershape__c.*;
import static gen.lib.common.routespl__c.*;
import static gen.lib.common.shapes__c.*;
import static gen.lib.common.splines__c.*;
import static gen.lib.common.strcasecmp__c.*;
import static gen.lib.common.strncasecmp__c.*;
import static gen.lib.common.taper__c.*;
import static gen.lib.common.textspan__c.*;
import static gen.lib.common.timing__c.*;
import static gen.lib.common.utils__c.*;
import static gen.lib.common.y_tab__c.*;
import static gen.lib.dotgen.acyclic__c.*;
import static gen.lib.dotgen.aspect__c.*;
import static gen.lib.dotgen.class1__c.*;
import static gen.lib.dotgen.class2__c.*;
import static gen.lib.dotgen.cluster__c.*;
import static gen.lib.dotgen.compound__c.*;
import static gen.lib.dotgen.conc__c.*;
import static gen.lib.dotgen.decomp__c.*;
import static gen.lib.dotgen.dotinit__c.*;
import static gen.lib.dotgen.dotsplines__c.*;
import static gen.lib.dotgen.fastgr__c.*;
import static gen.lib.dotgen.flat__c.*;
import static gen.lib.dotgen.mincross__c.*;
import static gen.lib.dotgen.position__c.*;
import static gen.lib.dotgen.rank__c.*;
import static gen.lib.dotgen.sameport__c.*;
import static gen.lib.dotgen2.decomp__c.*;
import static gen.lib.dotgen2.dotinit__c.*;
import static gen.lib.dotgen2.groups__c.*;
import static gen.lib.dotgen2.level__c.*;
import static gen.lib.dotgen2.minc2__c.*;
import static gen.lib.dotgen2.minc_utils__c.*;
import static gen.lib.dotgen2.ns__c.*;
import static gen.lib.fdpgen.clusteredges__c.*;
import static gen.lib.fdpgen.comp__c.*;
import static gen.lib.fdpgen.dbg__c.*;
import static gen.lib.fdpgen.fdpinit__c.*;
import static gen.lib.fdpgen.grid__c.*;
import static gen.lib.fdpgen.layout__c.*;
import static gen.lib.fdpgen.tlayout__c.*;
import static gen.lib.fdpgen.xlayout__c.*;
import static gen.lib.gvc.gvbuffstderr__c.*;
import static gen.lib.gvc.gvconfig__c.*;
import static gen.lib.gvc.gvcontext__c.*;
import static gen.lib.gvc.gvc__c.*;
import static gen.lib.gvc.gvdevice__c.*;
import static gen.lib.gvc.gvevent__c.*;
import static gen.lib.gvc.gvjobs__c.*;
import static gen.lib.gvc.gvlayout__c.*;
import static gen.lib.gvc.gvloadimage__c.*;
import static gen.lib.gvc.gvplugin__c.*;
import static gen.lib.gvc.gvrender__c.*;
import static gen.lib.gvc.gvtextlayout__c.*;
import static gen.lib.gvc.gvusershape__c.*;
import static gen.lib.gvc.regex_win32__c.*;
import static gen.lib.label.index__c.*;
import static gen.lib.label.node__c.*;
import static gen.lib.label.nrtmain__c.*;
import static gen.lib.label.rectangle__c.*;
import static gen.lib.label.split_q__c.*;
import static gen.lib.label.xlabels__c.*;
import static gen.lib.ortho.fPQ__c.*;
import static gen.lib.ortho.maze__c.*;
import static gen.lib.ortho.ortho__c.*;
import static gen.lib.ortho.partition__c.*;
import static gen.lib.ortho.rawgraph__c.*;
import static gen.lib.ortho.sgraph__c.*;
import static gen.lib.ortho.trapezoid__c.*;
import static gen.lib.pack.ccomps__c.*;
import static gen.lib.pack.pack__c.*;
import static gen.lib.pack.ptest__c.*;
import static gen.lib.pathplan.cvt__c.*;
import static gen.lib.pathplan.inpoly__c.*;
import static gen.lib.pathplan.route__c.*;
import static gen.lib.pathplan.shortestpth__c.*;
import static gen.lib.pathplan.shortest__c.*;
import static gen.lib.pathplan.solvers__c.*;
import static gen.lib.pathplan.triang__c.*;
import static gen.lib.pathplan.util__c.*;
import static gen.lib.pathplan.visibility__c.*;
import static gen.lib.xdot.xdot__c.*;

public class route__c {
//1 baedz5i9est5csw3epz3cv7z
// typedef Ppoly_t Ppolyline_t


//1 7pb9zum2n4wlgil34lvh8i0ts
// typedef double COORD


//1 540u5gu9i0x1wzoxqqx5n2vwp
// static jmp_buf jbuf
private static jmp_buf jbuf = new jmp_buf();

//1 3k2f2er3efsrl0210su710vf
// static Ppoint_t *ops
static private __ptr__ ops;

//1 ds2k0zdfzruet3qxk0duytkjx
// static int opn, opl
private static int opn, opl;



//3 9stmrdqlmufyk2wutp3totr5j
// int Proutespline(Pedge_t * edges, int edgen, Ppolyline_t input, 		 Ppoint_t * evs, Ppolyline_t * output) 
public static int Proutespline(__ptr__ edges, int edgen, final __struct__<Ppoly_t> input, __ptr__ evs, __ptr__ output) {
// WARNING!! STRUCT
return Proutespline_w_(edges, edgen, input.copy(), evs, output);
}
private static int Proutespline_w_(__ptr__ edges, int edgen, final __struct__<Ppoly_t> input, __ptr__ evs, __ptr__ output) {
ENTERING("9stmrdqlmufyk2wutp3totr5j","Proutespline");
try {
    __ptr__ inps;
    int inpn;
    /* unpack into previous format rather than modify legacy code */
    inps = input.getPtr("ps");
    inpn = input.getInt("pn");
    if (setjmp(jbuf)!=0)
UNSUPPORTED("8d9xfgejx5vgd6shva5wk5k06"); // 	return -1;
    /* generate the splines */
    evs.plus(0).getStruct().____(normv(evs.plus(0).getStruct()));
    evs.plus(1).getStruct().____(normv(evs.plus(1).getStruct()));
    opl = 0;
    growops(4);
    ops.plus(opl).setStruct(inps.plus(0).getStruct());
    opl++;
    if (reallyroutespline(edges, edgen, inps, inpn, evs.plus(0).getStruct(), evs.plus(1).getStruct()) == -1)
	return -1;
    output.setInt("pn", opl);
    output.setPtr("ps", ops);
    return 0;
} finally {
LEAVING("9stmrdqlmufyk2wutp3totr5j","Proutespline");
}
}




//3 13dxqzbgtpl4ubnnvw6ehzzi9
// static int reallyroutespline(Pedge_t * edges, int edgen, 			     Ppoint_t * inps, int inpn, Ppoint_t ev0, 			     Ppoint_t ev1) 
private static __ptr__ tnas;
private static int tnan;
public static int reallyroutespline(__ptr__ edges, int edgen, __ptr__ inps, int inpn, final __struct__<pointf> ev0, final __struct__<pointf> ev1) {
// WARNING!! STRUCT
return reallyroutespline_w_(edges, edgen, inps, inpn, ev0.copy(), ev1.copy());
}
private static int reallyroutespline_w_(__ptr__ edges, int edgen, __ptr__ inps, int inpn, final __struct__<pointf> ev0, final __struct__<pointf> ev1) {
ENTERING("13dxqzbgtpl4ubnnvw6ehzzi9","reallyroutespline");
try {
    final __struct__<pointf> p1 = __struct__.from(pointf.class), p2 = __struct__.from(pointf.class), cp1 = __struct__.from(pointf.class), cp2 = __struct__.from(pointf.class), p = __struct__.from(pointf.class);
    final __struct__<pointf> v1 = __struct__.from(pointf.class), v2 = __struct__.from(pointf.class), splitv = __struct__.from(pointf.class), splitv1 = __struct__.from(pointf.class), splitv2 = __struct__.from(pointf.class);
    double maxd, d, t;
    int maxi, i, spliti;
    if (tnan < inpn) {
	if (N(tnas)) {
	    if (N(tnas = Memory.malloc(sizeof(tna_t.class, inpn))))
		return -1;
	} else {
	    if (N(tnas = Memory.realloc(tnas, sizeof(tna_t.class, inpn))))
		return -1;
	}
	tnan = inpn;
    }
    tnas.plus(0).getStruct().setDouble("t", 0);
    for (i = 1; i < inpn; i++)
	tnas.plus(i).getStruct().setDouble("t", tnas.plus(i-1).getStruct().getDouble("t") + dist(inps.plus(i).getStruct(), inps.plus(i-1).getStruct()));
    for (i = 1; i < inpn; i++)
	tnas.plus(i).getStruct().setDouble("t", tnas.plus(i).getStruct().getDouble("t") / tnas.plus(inpn - 1).getStruct().getDouble("t"));
    for (i = 0; i < inpn; i++) {
	tnas.plus(i).getStruct().getArray("a").plus(0).setStruct(scale(ev0, B1(tnas.plus(i).getStruct().getDouble("t"))));
	tnas.plus(i).getStruct().getArray("a").plus(1).setStruct(scale(ev1, B2(tnas.plus(i).getStruct().getDouble("t"))));
    }
    if (mkspline(inps, inpn, tnas, ev0, ev1, p1.amp(), v1.amp(), p2.amp(), v2.amp()) == -1)
	return -1;
    if (splinefits(edges, edgen, p1, v1, p2, v2, inps, inpn)!=0)
	return 0;
UNSUPPORTED("d2oxz9352quicl35l2d3dm50s"); //     cp1 = add(p1, scale(v1, 1 / 3.0));
UNSUPPORTED("d1yieqsrwyu7pr0rd88ybn6sk"); //     cp2 = sub(p2, scale(v2, 1 / 3.0));
UNSUPPORTED("7xy5zkzbu6qutvb5f7npjonal"); //     for (maxd = -1, maxi = -1, i = 1; i < inpn - 1; i++) {
UNSUPPORTED("c527ncexcnhg9qclevsgg46to"); // 	t = tnas[i].t;
UNSUPPORTED("jpudiq150i4kbwz8onylgx5l"); // 	p.x = B0(t) * p1.x + B1(t) * cp1.x + B2(t) * cp2.x + B3(t) * p2.x;
UNSUPPORTED("9o015n1oh1sq0v2c8s55ec7wd"); // 	p.y = B0(t) * p1.y + B1(t) * cp1.y + B2(t) * cp2.y + B3(t) * p2.y;
UNSUPPORTED("6mcv8t9ihol19h9pydemdn3z"); // 	if ((d = dist(p, inps[i])) > maxd)
UNSUPPORTED("51f153p37z4p82a9swq6pl1uc"); // 	    maxd = d, maxi = i;
UNSUPPORTED("dvgyxsnyeqqnyzq696k3vskib"); //     }
UNSUPPORTED("3m5ar5uy4bych3rry4xjafo2z"); //     spliti = maxi;
UNSUPPORTED("35qrvyhcvcyn05kqby4nrkxw2"); //     splitv1 = normv(sub(inps[spliti], inps[spliti - 1]));
UNSUPPORTED("4vpzs9dwflivbpzpbtvrxv8qc"); //     splitv2 = normv(sub(inps[spliti + 1], inps[spliti]));
UNSUPPORTED("do5ofp56abb8kz9jbza7yu7gx"); //     splitv = normv(add(splitv1, splitv2));
UNSUPPORTED("biexrjbmm6sc9tuqasn4qntzv"); //     reallyroutespline(edges, edgen, inps, spliti + 1, ev0, splitv);
UNSUPPORTED("8h13rxqbjec94jyq8hiberliv"); //     reallyroutespline(edges, edgen, &inps[spliti], inpn - spliti, splitv,
UNSUPPORTED("1m3t7k9blca5xjqe5vt1w5t46"); // 		      ev1);
UNSUPPORTED("5oxhd3fvp0gfmrmz12vndnjt"); //     return 0;
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
} finally {
LEAVING("13dxqzbgtpl4ubnnvw6ehzzi9","reallyroutespline");
}
}




//3 29sok6jkfyobf83q130snkhmh
// static int mkspline(Ppoint_t * inps, int inpn, tna_t * tnas, Ppoint_t ev0, 		    Ppoint_t ev1, Ppoint_t * sp0, Ppoint_t * sv0, 		    Ppoint_t * sp1, Ppoint_t * sv1) 
public static int mkspline(__ptr__ inps, int inpn, __ptr__ tnas, final __struct__<pointf> ev0, final __struct__<pointf> ev1, __ptr__ sp0, __ptr__ sv0, __ptr__ sp1, __ptr__ sv1) {
// WARNING!! STRUCT
return mkspline_w_(inps, inpn, tnas, ev0.copy(), ev1.copy(), sp0, sv0, sp1, sv1);
}
private static int mkspline_w_(__ptr__ inps, int inpn, __ptr__ tnas, final __struct__<pointf> ev0, final __struct__<pointf> ev1, __ptr__ sp0, __ptr__ sv0, __ptr__ sp1, __ptr__ sv1) {
ENTERING("29sok6jkfyobf83q130snkhmh","mkspline");
try {
    final __struct__<pointf> tmp = __struct__.from(pointf.class);
    double c[][] = new double[2][2];
    double x[] = new double[2];
    double det01, det0X, detX1;
    double d01, scale0, scale3;
    int i;
    scale0 = scale3 = 0.0;
    c[0][0] = c[0][1] = c[1][0] = c[1][1] = 0.0;
    x[0] = x[1] = 0.0;
    for (i = 0; i < inpn; i++) {
	c[0][0] += dot(tnas.plus(i).getStruct().getArray("a").plus(0).getStruct(), tnas.plus(i).getStruct().getArray("a").plus(0).getStruct());
	c[0][1] += dot(tnas.plus(i).getStruct().getArray("a").plus(0).getStruct(), tnas.plus(i).getStruct().getArray("a").plus(1).getStruct());
	c[1][0] = c[0][1];
	c[1][1] += dot(tnas.plus(i).getStruct().getArray("a").plus(1).getStruct(), tnas.plus(i).getStruct().getArray("a").plus(1).getStruct());
	tmp.____(sub(inps.plus(i).getStruct(), add(scale(inps.plus(0).getStruct(), B01(tnas.plus(i).getStruct().getDouble("t"))),
			       scale(inps.plus(inpn - 1).getStruct(), B23(tnas.plus(i).getStruct().getDouble("t"))))));
	x[0] += dot(tnas.plus(i).getStruct().getArray("a").plus(0).getStruct(), tmp);
	x[1] += dot(tnas.plus(i).getStruct().getArray("a").plus(1).getStruct(), tmp);
    }
    det01 = c[0][0] * c[1][1] - c[1][0] * c[0][1];
    det0X = c[0][0] * x[1] - c[0][1] * x[0];
    detX1 = x[0] * c[1][1] - x[1] * c[0][1];
    if (((det01) >= 0 ? (det01) : -(det01)) >= 1e-6) {
	scale0 = detX1 / det01;
	scale3 = det0X / det01;
    }
    if (((det01) >= 0 ? (det01) : -(det01)) < 1e-6 || scale0 <= 0.0 || scale3 <= 0.0) {
	d01 = dist(inps.plus(0).getStruct(), inps.plus(inpn - 1).getStruct()) / 3.0;
	scale0 = d01;
	scale3 = d01;
    }
    sp0.setStruct(inps.plus(0).getStruct());
    sv0.setStruct(scale(ev0, scale0));
    sp1.setStruct(inps.plus(inpn - 1).getStruct());
    sv1.setStruct(scale(ev1, scale3));
    return 0;
} finally {
LEAVING("29sok6jkfyobf83q130snkhmh","mkspline");
}
}




//3 ea6jsc0rwfyjtmmuxax6r5ngk
// static double dist_n(Ppoint_t * p, int n) 
public static double dist_n(__ptr__ p, int n) {
ENTERING("ea6jsc0rwfyjtmmuxax6r5ngk","dist_n");
try {
    int i;
    double rv;
    rv = 0.0;
    for (i = 1; i < n; i++) {
	rv +=
	    sqrt((p.plus(i).getStruct().getDouble("x") - p.plus(i - 1).getStruct().getDouble("x")) * (p.plus(i).getStruct().getDouble("x") - p.plus(i - 1).getStruct().getDouble("x"))+
		 (p.plus(i).getStruct().getDouble("y") - p.plus(i - 1).getStruct().getDouble("y")) * (p.plus(i).getStruct().getDouble("y") - p.plus(i - 1).getStruct().getDouble("y")));
    }
    return rv;
} finally {
LEAVING("ea6jsc0rwfyjtmmuxax6r5ngk","dist_n");
}
}




//3 987ednrgu5qo9dzhpiox47mhb
// static int splinefits(Pedge_t * edges, int edgen, Ppoint_t pa, 		      Pvector_t va, Ppoint_t pb, Pvector_t vb, 		      Ppoint_t * inps, int inpn) 
public static int splinefits(__ptr__ edges, int edgen, final __struct__<pointf> pa, final __struct__<pointf> va, final __struct__<pointf> pb, final __struct__<pointf> vb, __ptr__ inps, int inpn) {
// WARNING!! STRUCT
return splinefits_w_(edges, edgen, pa.copy(), va.copy(), pb.copy(), vb.copy(), inps, inpn);
}
private static int splinefits_w_(__ptr__ edges, int edgen, final __struct__<pointf> pa, final __struct__<pointf> va, final __struct__<pointf> pb, final __struct__<pointf> vb, __ptr__ inps, int inpn) {
ENTERING("987ednrgu5qo9dzhpiox47mhb","splinefits");
try {
    final __array__ sps = __array__.malloc(pointf.class, 4);
    double a, b;
    int pi;
    int forceflag;
    int first = 1;
    forceflag = (inpn == 2 ? 1 : 0);
    a = b = 4;
    for (;;) {
	sps.plus(0).getStruct().setDouble("x", pa.getDouble("x"));
	sps.plus(0).getStruct().setDouble("y", pa.getDouble("y"));
	sps.plus(1).getStruct().setDouble("x", pa.getDouble("x") + a * va.getDouble("x") / 3.0);
	sps.plus(1).getStruct().setDouble("y", pa.getDouble("y") + a * va.getDouble("y") / 3.0);
	sps.plus(2).getStruct().setDouble("x", pb.getDouble("x") - b * vb.getDouble("x") / 3.0);
	sps.plus(2).getStruct().setDouble("y", pb.getDouble("y") - b * vb.getDouble("y") / 3.0);
	sps.plus(3).getStruct().setDouble("x", pb.getDouble("x"));
	sps.plus(3).getStruct().setDouble("y", pb.getDouble("y"));
	/* shortcuts (paths shorter than the shortest path) not allowed -
	 * they must be outside the constraint polygon.  this can happen
	 * if the candidate spline intersects the constraint polygon exactly
	 * on sides or vertices.  maybe this could be more elegant, but
	 * it solves the immediate problem. we could also try jittering the
	 * constraint polygon, or computing the candidate spline more carefully,
	 * for example using the path. SCN */
	if (first!=0 && (dist_n(sps.asPtr(), 4) < (dist_n(inps, inpn) - 1E-3)))
	    return 0;
	first = 0;
	if (splineisinside(edges, edgen, sps)!=0) {
	    growops(opl + 4);
	    for (pi = 1; pi < 4; pi++) {
		ops.plus(opl).setDouble("x", sps.plus(pi).getStruct().getDouble("x"));
		ops.plus(opl).setDouble("y", sps.plus(pi).getStruct().getDouble("y"));
		opl++;
		}
	    return 1;
	}
	if (a == 0 && b == 0) {
	    if (forceflag!=0) {
		growops(opl + 4);
		for (pi = 1; pi < 4; pi++)
		{
			ops.plus(opl).setDouble("x", sps.plus(pi).getStruct().getDouble("x"));
			ops.plus(opl).setDouble("y", sps.plus(pi).getStruct().getDouble("y"));
		    opl++;
		}
		return 1;
	    }
	    break;
	}
	if (a > .01)
	{
	    a /= 2;
	    b /= 2;
	}
	else
	    a = b = 0;
    }
    return 0;
} finally {
LEAVING("987ednrgu5qo9dzhpiox47mhb","splinefits");
}
}




//3 an68if9f4tox43kcnu34vchbk
// static int splineisinside(Pedge_t * edges, int edgen, Ppoint_t * sps) 
public static int splineisinside(__ptr__ edges, int edgen, __array__ sps) {
ENTERING("an68if9f4tox43kcnu34vchbk","splineisinside");
try {
    double roots[] = new double[4];
    int rooti, rootn;
    int ei;
    final __array__ lps = __array__.malloc(pointf.class, 2);
    final __struct__<pointf> ip = __struct__.from(pointf.class);
    double t, ta, tb, tc, td;
    for (ei = 0; ei < edgen; ei++) {
	lps.plus(0).setStruct(edges.plus(ei).getStruct("a"));
	lps.plus(1).setStruct(edges.plus(ei).getStruct("b"));
	/* if ((rootn = splineintersectsline (sps, lps, roots)) == 4)
	   return 1; */
	if ((rootn = splineintersectsline(sps, lps, roots)) == 4)
	    continue;
	for (rooti = 0; rooti < rootn; rooti++) {
	    if (roots[rooti] < 1E-6 || roots[rooti] > 1 - 1E-6)
		continue;
	    t = roots[rooti];
	    td = t * t * t;
	    tc = 3 * t * t * (1 - t);
	    tb = 3 * t * (1 - t) * (1 - t);
	    ta = (1 - t) * (1 - t) * (1 - t);
	    ip.setDouble("x", ta * sps.plus(0).getDouble("x") + tb * sps.plus(1).getDouble("x") +
		tc * sps.plus(2).getDouble("x") + td * sps.plus(3).getDouble("x"));
	    ip.setDouble("y", ta * sps.plus(0).getDouble("y") + tb * sps.plus(1).getDouble("y") +
		tc * sps.plus(2).getDouble("y") + td * sps.plus(3).getDouble("y"));
	    if (( ((ip.getDouble("x") - lps.plus(0).getStruct().getDouble("x")) * (ip.getDouble("x") - lps.plus(0).getStruct().getDouble("x"))) + ((ip.getDouble("y") - lps.plus(0).getStruct().getDouble("y")) * (ip.getDouble("y") - lps.plus(0).getStruct().getDouble("y"))) ) < 1E-3 ||
		( ((ip.getDouble("x") - lps.plus(1).getStruct().getDouble("x")) * (ip.getDouble("x") - lps.plus(1).getStruct().getDouble("x"))) + ((ip.getDouble("y") - lps.plus(1).getStruct().getDouble("y")) * (ip.getDouble("y") - lps.plus(1).getStruct().getDouble("y"))) ) < 1E-3)
		continue;
	    return 0;
	}
    }
    return 1;
} finally {
LEAVING("an68if9f4tox43kcnu34vchbk","splineisinside");
}
}




//3 32nc8itszi77u36la8npt2870
// static int splineintersectsline(Ppoint_t * sps, Ppoint_t * lps, 				double *roots) 
public static int splineintersectsline(__array__ sps, __array__ lps, double roots[]) {
ENTERING("32nc8itszi77u36la8npt2870","splineintersectsline");
try {
    double scoeff[] = new double[4];
    double xcoeff[] = new double[2];
    double ycoeff[] = new double[2];
    double xroots[] = new double[3];
    double yroots[] = new double[3];
    double tv, sv, rat;
    int rootn[] = new int[]{0};
    int xrootn, yrootn, i, j;
    xcoeff[0] = lps.plus(0).getStruct().getDouble("x");
    xcoeff[1] = lps.plus(1).getStruct().getDouble("x") - lps.plus(0).getStruct().getDouble("x");
    ycoeff[0] = lps.plus(0).getStruct().getDouble("y");
    ycoeff[1] = lps.plus(1).getStruct().getDouble("y") - lps.plus(0).getStruct().getDouble("y");
    rootn[0] = 0;
    if (xcoeff[1] == 0) {
 	if (ycoeff[1] == 0) {
	    points2coeff(sps.plus(0).getStruct().getDouble("x"), sps.plus(1).getStruct().getDouble("x"), sps.plus(2).getStruct().getDouble("x"), sps.plus(3).getStruct().getDouble("x"), scoeff);
	    scoeff[0] -= xcoeff[0];
	    xrootn = solve3(scoeff, xroots);
	    points2coeff(sps.plus(0).getStruct().getDouble("y"), sps.plus(1).getStruct().getDouble("y"), sps.plus(2).getStruct().getDouble("y"), sps.plus(3).getStruct().getDouble("y"), scoeff);
	    scoeff[0] -= ycoeff[0];
	    yrootn = solve3(scoeff, yroots);
	    if (xrootn == 4)
		if (yrootn == 4)
		    return 4;
		else
		    for (j = 0; j < yrootn; j++)
			addroot(yroots[j], roots, rootn);
	    else if (yrootn == 4)
		for (i = 0; i < xrootn; i++)
		    addroot(xroots[i], roots, rootn);
	    else
		for (i = 0; i < xrootn; i++)
		    for (j = 0; j < yrootn; j++)
			if (xroots[i] == yroots[j])
			    addroot(xroots[i], roots, rootn);
	    return rootn[0];
	} else {
 	    points2coeff(sps.plus(0).getStruct().getDouble("x"), sps.plus(1).getStruct().getDouble("x"), sps.plus(2).getStruct().getDouble("x"), sps.plus(3).getStruct().getDouble("x"), scoeff);
 	    scoeff[0] -= xcoeff[0];
	    xrootn = solve3(scoeff, xroots);
	    if (xrootn == 4)
		return 4;
	    for (i = 0; i < xrootn; i++) {
		tv = xroots[i];
		if (tv >= 0 && tv <= 1) {
		    points2coeff(sps.plus(0).getStruct().getDouble("y"), sps.plus(1).getStruct().getDouble("y"), sps.plus(2).getStruct().getDouble("y"), sps.plus(3).getStruct().getDouble("y"),
				 scoeff);
		    sv = scoeff[0] + tv * (scoeff[1] + tv *
					   (scoeff[2] + tv * scoeff[3]));
		    sv = (sv - ycoeff[0]) / ycoeff[1];
		    if ((0 <= sv) && (sv <= 1))
			addroot(tv, roots, rootn);
		}
	    }
	    return rootn[0];
	}
    } else {
	rat = ycoeff[1] / xcoeff[1];
	points2coeff(sps.plus(0).getStruct().getDouble("y") - rat * sps.plus(0).getStruct().getDouble("x"), sps.plus(1).getStruct().getDouble("y") - rat * sps.plus(1).getStruct().getDouble("x"),
		     sps.plus(2).getStruct().getDouble("y") - rat * sps.plus(2).getStruct().getDouble("x"), sps.plus(3).getStruct().getDouble("y") - rat * sps.plus(3).getStruct().getDouble("x"),
		     scoeff);
	scoeff[0] += rat * xcoeff[0] - ycoeff[0];
	xrootn = solve3(scoeff, xroots);
	if (xrootn == 4)
	    return 4;
	for (i = 0; i < xrootn; i++) {
	    tv = xroots[i];
	    if (tv >= 0 && tv <= 1) {
		points2coeff(sps.plus(0).getStruct().getDouble("x"), sps.plus(1).getStruct().getDouble("x"), sps.plus(2).getStruct().getDouble("x"), sps.plus(3).getStruct().getDouble("x"),
			     scoeff);
		sv = scoeff[0] + tv * (scoeff[1] +
				       tv * (scoeff[2] + tv * scoeff[3]));
		sv = (sv - xcoeff[0]) / xcoeff[1];
		if ((0 <= sv) && (sv <= 1))
		    addroot(tv, roots, rootn);
	    }
	}
	return rootn[0];
	}
} finally {
LEAVING("32nc8itszi77u36la8npt2870","splineintersectsline");
}
}




//3 9011b45d42bhwfxzhgxqnlfhp
// static void points2coeff(double v0, double v1, double v2, double v3, 			 double *coeff) 
public static void points2coeff(double v0, double v1, double v2, double v3, double coeff[]) {
ENTERING("9011b45d42bhwfxzhgxqnlfhp","points2coeff");
try {
    coeff[3] = v3 + 3 * v1 - (v0 + 3 * v2);
    coeff[2] = 3 * v0 + 3 * v2 - 6 * v1;
    coeff[1] = 3 * (v1 - v0);
    coeff[0] = v0;
} finally {
LEAVING("9011b45d42bhwfxzhgxqnlfhp","points2coeff");
}
}




//3 6ldk438jjflh0huxkg4cs8kwu
// static void addroot(double root, double *roots, int *rootnp) 
public static void addroot(double root, double roots[], int rootnp[]) {
ENTERING("6ldk438jjflh0huxkg4cs8kwu","addroot");
try {
    if (root >= 0 && root <= 1) {
	roots[rootnp[0]] = root;
	rootnp[0]++;
	}
} finally {
LEAVING("6ldk438jjflh0huxkg4cs8kwu","addroot");
}
}




//3 3i8m1m9fg7qmnt8jloorwlu8e
// static Pvector_t normv(Pvector_t v) 
public static __struct__<pointf> normv(final __struct__<pointf> v) {
// WARNING!! STRUCT
return normv_w_(v.copy()).copy();
}
private static __struct__<pointf> normv_w_(final __struct__<pointf> v) {
ENTERING("3i8m1m9fg7qmnt8jloorwlu8e","normv");
try {
    double d;
    d = v.getDouble("x") * v.getDouble("x") + v.getDouble("y") * v.getDouble("y");
    if (d > 1e-6) {
	d = sqrt(d);
	v.setDouble("x", v.getDouble("x") / d);
	v.setDouble("y", v.getDouble("y") / d);
    }
    return v;
} finally {
LEAVING("3i8m1m9fg7qmnt8jloorwlu8e","normv");
}
}




//3 d59jcnpi1y0wr8e9uwxny2fvk
// static void growops(int newopn) 
public static void growops(int newopn) {
ENTERING("d59jcnpi1y0wr8e9uwxny2fvk","growops");
try {
    if (newopn <= opn)
	return;
    if (N(ops)) {
	if (N(ops = Memory.malloc(sizeof (pointf.class, newopn)))) {
UNSUPPORTED("413an1hqgkb4ezaec6qdsdplx"); // 	    fprintf (stderr, "libpath/%s:%d: %s\n", "graphviz-2.38.0\\lib\\pathplan\\route.c", 32, ("cannot malloc ops"));
UNSUPPORTED("1r6uhbnmxv8c6msnscw07w0qx"); // 	    longjmp(jbuf,1);
	}
    } else {
	if (N(ops = Memory.realloc(ops,
					 sizeof (pointf.class, newopn)))) {
UNSUPPORTED("8u0qgahxvk5pplf90thmhwxhl"); // 	    fprintf (stderr, "libpath/%s:%d: %s\n", "graphviz-2.38.0\\lib\\pathplan\\route.c", 32, ("cannot realloc ops"));
UNSUPPORTED("1r6uhbnmxv8c6msnscw07w0qx"); // 	    longjmp(jbuf,1);
	}
    }
    opn = newopn;
} finally {
LEAVING("d59jcnpi1y0wr8e9uwxny2fvk","growops");
}
}




//3 f4a7nt247bokdwr2owda050of
// static Ppoint_t add(Ppoint_t p1, Ppoint_t p2) 
public static __struct__<pointf> add(final __struct__<pointf> p1, final __struct__<pointf> p2) {
// WARNING!! STRUCT
return add_w_(p1.copy(), p2.copy()).copy();
}
private static __struct__<pointf> add_w_(final __struct__<pointf> p1, final __struct__<pointf> p2) {
ENTERING("f4a7nt247bokdwr2owda050of","add");
try {
    p1.setDouble("x", p1.getDouble("x") + p2.getDouble("x"));
    p1.setDouble("y", p1.getDouble("y") + p2.getDouble("y"));
    return p1;
} finally {
LEAVING("f4a7nt247bokdwr2owda050of","add");
}
}




//3 c4l1gvlkv2s4mi6os7r9dh89f
// static Ppoint_t sub(Ppoint_t p1, Ppoint_t p2) 
public static __struct__<pointf> sub(final __struct__<pointf> p1, final  __struct__<pointf> p2) {
// WARNING!! STRUCT
return sub_w_(p1.copy(), p2.copy()).copy();
}
private static __struct__<pointf> sub_w_(final __struct__<pointf> p1, final  __struct__<pointf> p2) {
ENTERING("c4l1gvlkv2s4mi6os7r9dh89f","sub");
try {
    p1.setDouble("x", p1.getDouble("x") - p2.getDouble("x"));
    p1.setDouble("y", p1.getDouble("y") - p2.getDouble("y"));
    return p1;
} finally {
LEAVING("c4l1gvlkv2s4mi6os7r9dh89f","sub");
}
}




//3 dqnlz0tceriykws4ngudl94w9
// static double dist(Ppoint_t p1, Ppoint_t p2) 
public static double dist(final __struct__<pointf> p1, final __struct__<pointf> p2) {
// WARNING!! STRUCT
return dist_w_(p1.copy(), p2.copy());
}
private static double dist_w_(final __struct__<pointf> p1, final __struct__<pointf> p2) {
ENTERING("dqnlz0tceriykws4ngudl94w9","dist");
try {
    double dx, dy;
    dx = p2.getDouble("x") - p1.getDouble("x");
    dy = p2.getDouble("y") - p1.getDouble("y");
    return sqrt(dx * dx + dy * dy);
} finally {
LEAVING("dqnlz0tceriykws4ngudl94w9","dist");
}
}




//3 19149pdllzhplvew0bsh5v6hy
// static Ppoint_t scale(Ppoint_t p, double c) 
public static __struct__<pointf> scale(final __struct__<pointf> p, double c) {
// WARNING!! STRUCT
return scale_w_(p.copy(), c).copy();
}
private static __struct__<pointf> scale_w_(final __struct__<pointf> p, double c) {
ENTERING("19149pdllzhplvew0bsh5v6hy","scale");
try {
    p.setDouble("x", p.getDouble("x") * c);
    p.setDouble("y", p.getDouble("y") * c);
    return p;
} finally {
LEAVING("19149pdllzhplvew0bsh5v6hy","scale");
}
}




//3 7ebsa2s1eoopqj1pp43bh5fw
// static double dot(Ppoint_t p1, Ppoint_t p2) 
public static double dot(final __struct__<pointf> p1, final __struct__<pointf> p2) {
// WARNING!! STRUCT
return dot_w_(p1.copy(), p2.copy());
}
private static double dot_w_(final __struct__<pointf> p1, final __struct__<pointf> p2) {
ENTERING("7ebsa2s1eoopqj1pp43bh5fw","dot");
try {
    return p1.getDouble("x") * p2.getDouble("x") + p1.getDouble("y") * p2.getDouble("y");
} finally {
LEAVING("7ebsa2s1eoopqj1pp43bh5fw","dot");
}
}




//3 73nhv3cuxqa9va0puve0ji2d5
// static double B0(double t) 
public static Object B0(Object... arg) {
UNSUPPORTED("1uwuajk3czp61ywjcdz28kaln"); // static double B0(double t)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("cjnnjlw1oa4lvlksyd7031xtp"); //     double tmp = 1.0 - t;
UNSUPPORTED("e3dzvz3i6wua9nwqv7gwdh5ak"); //     return tmp * tmp * tmp;
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 jkfs4ak0xr5pzwye7qnm6irp
// static double B1(double t) 
public static double B1(double t) {
ENTERING("jkfs4ak0xr5pzwye7qnm6irp","B1");
try {
    double tmp = 1.0 - t;
    return 3 * t * tmp * tmp;
} finally {
LEAVING("jkfs4ak0xr5pzwye7qnm6irp","B1");
}
}




//3 9ziajuqys2xceftdw0vac02g9
// static double B2(double t) 
public static double B2(double t) {
ENTERING("9ziajuqys2xceftdw0vac02g9","B2");
try {
    double tmp = 1.0 - t;
    return 3 * t * t * tmp;
} finally {
LEAVING("9ziajuqys2xceftdw0vac02g9","B2");
}
}




//3 5sjstsgkvoou9grsty3y0cnvg
// static double B3(double t) 
public static Object B3(Object... arg) {
UNSUPPORTED("7z7cako7kxp81tn6g3lmfsgbn"); // static double B3(double t)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("bq0lp847jroig5jhbiztlbvq"); //     return t * t * t;
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 9hzfapzxcesobeegq4aokksbp
// static double B01(double t) 
public static double B01(double t) {
ENTERING("9hzfapzxcesobeegq4aokksbp","B01");
try {
    double tmp = 1.0 - t;
    return tmp * tmp * (tmp + 3 * t);
} finally {
LEAVING("9hzfapzxcesobeegq4aokksbp","B01");
}
}




//3 571cxp9l20eyvqjwdoy9vnc6t
// static double B23(double t) 
public static double B23(double t) {
ENTERING("571cxp9l20eyvqjwdoy9vnc6t","B23");
try {
    double tmp = 1.0 - t;
    return t * t * (3 * tmp + t);
} finally {
LEAVING("571cxp9l20eyvqjwdoy9vnc6t","B23");
}
}


}