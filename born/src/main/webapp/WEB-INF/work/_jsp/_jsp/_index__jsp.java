/*
 * JSP generated by Resin-3.1.12 (built Mon, 29 Aug 2011 03:22:08 PDT)
 */

package _jsp._jsp;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;

public class _index__jsp extends com.caucho.jsp.JavaPage
{
  private static final java.util.HashMap<String,java.lang.reflect.Method> _jsp_functionMap = new java.util.HashMap<String,java.lang.reflect.Method>();
  private boolean _caucho_isDead;
  
  public void
  _jspService(javax.servlet.http.HttpServletRequest request,
              javax.servlet.http.HttpServletResponse response)
    throws java.io.IOException, javax.servlet.ServletException
  {
    javax.servlet.http.HttpSession session = request.getSession(true);
    com.caucho.server.webapp.WebApp _jsp_application = _caucho_getApplication();
    javax.servlet.ServletContext application = _jsp_application;
    com.caucho.jsp.PageContextImpl pageContext = _jsp_application.getJspApplicationContext().allocatePageContext(this, _jsp_application, request, response, null, session, 8192, true, false);
    javax.servlet.jsp.PageContext _jsp_parentContext = pageContext;
    javax.servlet.jsp.JspWriter out = pageContext.getOut();
    final javax.el.ELContext _jsp_env = pageContext.getELContext();
    javax.servlet.ServletConfig config = getServletConfig();
    javax.servlet.Servlet page = this;
    response.setContentType("text/html; charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
    try {
      out.write(_jsp_string0, 0, _jsp_string0.length);
      out.print((request.getContextPath()));
      out.write(_jsp_string1, 0, _jsp_string1.length);
      pageContext.pageSetOrRemove("pageType", "index");
      out.write(_jsp_string2, 0, _jsp_string2.length);
      if (_caucho_expr_0.evalBoolean(_jsp_env)) {
        out.write(_jsp_string3, 0, _jsp_string3.length);
      }
      out.write(_jsp_string4, 0, _jsp_string4.length);
      if (_caucho_expr_1.evalBoolean(_jsp_env)) {
        out.write(_jsp_string3, 0, _jsp_string3.length);
      }
      out.write(_jsp_string5, 0, _jsp_string5.length);
      if (_caucho_expr_2.evalBoolean(_jsp_env)) {
        out.write(_jsp_string3, 0, _jsp_string3.length);
      }
      out.write(_jsp_string6, 0, _jsp_string6.length);
      if (_caucho_expr_3.evalBoolean(_jsp_env)) {
        out.write(_jsp_string3, 0, _jsp_string3.length);
      }
      out.write(_jsp_string7, 0, _jsp_string7.length);
      if (_caucho_expr_4.evalBoolean(_jsp_env)) {
        out.write(_jsp_string8, 0, _jsp_string8.length);
        _caucho_expr_5.print(out, _jsp_env, false);
        out.write(_jsp_string9, 0, _jsp_string9.length);
      }
      out.write(_jsp_string10, 0, _jsp_string10.length);
      if (_caucho_expr_6.evalBoolean(_jsp_env)) {
        out.write(_jsp_string11, 0, _jsp_string11.length);
      }
      out.write(_jsp_string12, 0, _jsp_string12.length);
      if (_caucho_expr_7.evalBoolean(_jsp_env)) {
        out.write(_jsp_string3, 0, _jsp_string3.length);
      }
      out.write(_jsp_string13, 0, _jsp_string13.length);
    } catch (java.lang.Throwable _jsp_e) {
      pageContext.handlePageException(_jsp_e);
    } finally {
      _jsp_application.getJspApplicationContext().freePageContext(pageContext);
    }
  }

  private java.util.ArrayList _caucho_depends = new java.util.ArrayList();

  public java.util.ArrayList _caucho_getDependList()
  {
    return _caucho_depends;
  }

  public void _caucho_addDepend(com.caucho.vfs.PersistentDependency depend)
  {
    super._caucho_addDepend(depend);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  public boolean _caucho_isModified()
  {
    if (_caucho_isDead)
      return true;
    if (com.caucho.server.util.CauchoSystem.getVersionId() != 7170261747151080670L)
      return true;
    for (int i = _caucho_depends.size() - 1; i >= 0; i--) {
      com.caucho.vfs.Dependency depend;
      depend = (com.caucho.vfs.Dependency) _caucho_depends.get(i);
      if (depend.isModified())
        return true;
    }
    return false;
  }

  public long _caucho_lastModified()
  {
    return 0;
  }

  public java.util.HashMap<String,java.lang.reflect.Method> _caucho_getFunctionMap()
  {
    return _jsp_functionMap;
  }

  public void init(ServletConfig config)
    throws ServletException
  {
    com.caucho.server.webapp.WebApp webApp
      = (com.caucho.server.webapp.WebApp) config.getServletContext();
    super.init(config);
    com.caucho.jsp.TaglibManager manager = webApp.getJspApplicationContext().getTaglibManager();
    manager.addTaglibFunctions(_jsp_functionMap, "c", "http://java.sun.com/jsp/jstl/core");
    manager.addTaglibFunctions(_jsp_functionMap, "fn", "http://java.sun.com/jsp/jstl/functions");
    com.caucho.jsp.PageContextImpl pageContext = new com.caucho.jsp.PageContextImpl(webApp, this);
    _caucho_expr_0 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${pageType == 'index'}");
    _caucho_expr_1 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${pageType == 'example'}");
    _caucho_expr_2 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${pageType == 'platform'}");
    _caucho_expr_3 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${pageType == 'user'}");
    _caucho_expr_4 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${user != null && user.isLogon()}");
    _caucho_expr_5 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${user.userName}");
    _caucho_expr_6 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${user == null || !user.isLogon()}");
    _caucho_expr_7 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${pageType == 'contactUs'}");
  }

  public void destroy()
  {
      _caucho_isDead = true;
      super.destroy();
  }

  public void init(com.caucho.vfs.Path appDir)
    throws javax.servlet.ServletException
  {
    com.caucho.vfs.Path resinHome = com.caucho.server.util.CauchoSystem.getResinHome();
    com.caucho.vfs.MergePath mergePath = new com.caucho.vfs.MergePath();
    mergePath.addMergePath(appDir);
    mergePath.addMergePath(resinHome);
    com.caucho.loader.DynamicClassLoader loader;
    loader = (com.caucho.loader.DynamicClassLoader) getClass().getClassLoader();
    String resourcePath = loader.getResourcePathSpecificFirst();
    mergePath.addClassPath(resourcePath);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("jsp/index.jsp"), -124540595008059597L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("jsp/common/common.jsp"), -8798942860517157903L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("jsp/common/header.jsp"), 863675120358004378L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("jsp/common/footer.jsp"), 9104851392891087358L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }
  private static com.caucho.el.Expr _caucho_expr_0;
  private static com.caucho.el.Expr _caucho_expr_1;
  private static com.caucho.el.Expr _caucho_expr_2;
  private static com.caucho.el.Expr _caucho_expr_3;
  private static com.caucho.el.Expr _caucho_expr_4;
  private static com.caucho.el.Expr _caucho_expr_5;
  private static com.caucho.el.Expr _caucho_expr_6;
  private static com.caucho.el.Expr _caucho_expr_7;

  private final static char []_jsp_string9;
  private final static char []_jsp_string12;
  private final static char []_jsp_string2;
  private final static char []_jsp_string11;
  private final static char []_jsp_string0;
  private final static char []_jsp_string4;
  private final static char []_jsp_string8;
  private final static char []_jsp_string13;
  private final static char []_jsp_string5;
  private final static char []_jsp_string10;
  private final static char []_jsp_string1;
  private final static char []_jsp_string6;
  private final static char []_jsp_string7;
  private final static char []_jsp_string3;
  static {
    _jsp_string9 = "</a>\r\n			<ul style=\"display:none\">\r\n				<li><a href=\"/user/loginOut\">\u767b\u51fa</a></li>\r\n			</ul>\r\n		".toCharArray();
    _jsp_string12 = "	\r\n		</li>\r\n		<li ".toCharArray();
    _jsp_string2 = "\r\n	\r\n<div id=\"header\">\r\n	<div id=\"smallLogo\"></div>\r\n	<ul id=\"menu\">\r\n		<li  ".toCharArray();
    _jsp_string11 = "\r\n			<a href=\"/user/login\">\u767b\u5f55</a>\r\n		".toCharArray();
    _jsp_string0 = "\r\n<!DOCTYPE html>\r\n<html>\r\n<head>\r\n	<title>\u7eb3\u7075\u79d1\u6280</title>\r\n	\r\n<base href=\"".toCharArray();
    _jsp_string4 = "><a href=\"/\">\u9996\u9875</a></li>\r\n		<li ".toCharArray();
    _jsp_string8 = "\r\n			<a href=\"/user/login\">".toCharArray();
    _jsp_string13 = "><a href=\"#\">\u8054\u7cfb\u6211\u4eec</a></li>\r\n	</ul>\r\n</div>\r\n\r\n\r\n	<div id=\"teaser\">\r\n		<div class=\"wrap\">\r\n			<div id=\"image\"></div>\r\n			<img src=\"\"/>\r\n			\r\n			<div class=\"box\">\r\n				<h2>\u7269\u8054\u7f51(Internet of things)</h2>\r\n				<p>\u7269\u8054\u7f51\u6b63\u5728\u4ece\u6839\u672c\u4e0a\u6539\u53d8\u4f01\u4e1a\u7684\u8fd0\u8425\u6a21\u5f0f\u4ee5\u53ca\u4eba\u4eec\u4e0e\u73b0\u5b9e\u4e16\u754c\u7684\u4e92\u52a8\u65b9\u5f0f\u3002\u5305\u62ec\u6c7d\u8f66\u3001\u4f20\u9001\u5e26\u751a\u81f3\u519c\u4f5c\u7269\u5728\u5185\u7684\u51e0\u4e4e\u6240\u6709\u4e8b\u7269\u90fd\u5b9e\u73b0\u4e86\u4e92\u8fde\u4e92\u901a\uff0c\u56e0\u6b64\u4f01\u4e1a\u8fd0\u7528\u6240\u4ea7\u751f\u7684\u6570\u636e\u8fdb\u884c\u5168\u9762\u7684\u4e1a\u52a1\u8f6c\u578b\u5df2\u662f\u5f53\u52a1\u4e4b\u6025\u3002</p>\r\n			</div>\r\n		</div>\r\n	</div>\r\n\r\n	<div id=\"bar\">\r\n		<div class=\"wrap\">\r\n			<span class=\"step\"><a>1</a> data collection</span>\r\n			<span class=\"step\"><a>2</a> behavior analysis</span>\r\n			<span class=\"step\"><a>3</a> equipment evolution</span>\r\n		</div>\r\n	</div>\r\n\r\n	<div class=\"wrap\">\r\n		<div class=\"col\">\r\n			<h3><span class=\"red\"> \u6570\u636e\u91c7\u96c6</span></h3>\r\n			<p>	&nbsp;&nbsp;&nbsp;&nbsp;\u7269\u8054\u7f51\u89c4\u6a21\u5e9e\u6742\uff0c\u800c\u4e14\u4e0d\u65ad\u53d8\u5316\u3002\u8bbe\u5907\u4e0e\u4eba\u5458\u4e4b\u95f4\u7684\u6570\u4ee5\u5341\u4ebf\u8ba1\u7684\u4e92\u52a8\uff0c\u6240\u4ea7\u751f\u7684\u7269\u8054\u7f51\u6570\u636e\u4e0d\u4ec5\u89c4\u6a21\u5e9e\u6742\uff0c\u800c\u4e14\u4e0d\u65ad\u53d8\u5316\u3002\u9884\u5148\u7f16\u5199\u7684\u7a0b\u5e8f\u5df2\u7ecf\u96be\u4ee5\u80dc\u4efb\u5bf9\u7269\u8054\u7f51\u6570\u636e\u7684\u5206\u6790\u4efb\u52a1\u3002\u4f20\u7edf\u7cfb\u7edf\u65e0\u6cd5\u901a\u8fc7\u5c06\u7269\u8054\u7f51\u6570\u636e\u4e0e\u5929\u6c14\u548c\u793e\u4ea4\u4e4b\u7c7b\u7684\u975e\u7ed3\u6784\u5316\u6570\u636e\u7ed3\u5408\u8d77\u6765\uff0c\u83b7\u5f97\u6709\u610f\u4e49\u7684\u6d1e\u5bdf\u3002</br>\r\n			</p>\r\n		</div>\r\n		<div class=\"col\">\r\n			<h3><span class=\"red\"> \u4eba\u673a\u4ea4\u4e92</span></h3>\r\n			<p>&nbsp;&nbsp;&nbsp;&nbsp;\u800c\u8ba4\u77e5\u578b\u7269\u8054\u7f51\u53ef\u4ee5\u8ba9\u6240\u6709\u7c7b\u578b\u7684\u6570\u636e\u53d1\u6325\u6700\u5927\u4f5c\u7528\u3002\u4e8b\u5b9e\u4e0a\uff0c\u5b83\u53ef\u4ee5\u9009\u62e9\u6570\u636e\u6e90\uff0c\u5e76\u786e\u5b9a\u8981\u7559\u610f\u7684\u6a21\u5f0f\u548c\u5173\u7cfb\u3002\u5b83\u4f7f\u7528\u673a\u5668\u5b66\u4e60\u548c\u9ad8\u7ea7\u5904\u7406\u80fd\u529b\u6765\u7ec4\u7ec7\u6570\u636e\uff0c\u5f62\u6210\u6d1e\u5bdf\u3002\u8ba4\u77e5\u578b\u7269\u8054\u7f51\u8fd8\u53ef\u4ee5\u901a\u8fc7\u5b66\u4e60\u8fdb\u884c\u81ea\u6211\u7ea0\u6b63\u548c\u81ea\u6211\u9002\u5e94\uff0c\u4e0d\u65ad\u8fdb\u5316\uff0c\u4e0d\u65ad\u6539\u8fdb\u3002</p>\r\n		</div>\r\n		<div class=\"col last\">\r\n			<h3>\u901a\u8fc7\u7eb3\u7075\u7269\u8054\u7f51\uff0c <span class=\"red\">\u60a8\u53ef\u4ee5</span></h3>	\r\n			<p >			\u66f4\u597d\u7684\u7ba1\u7406\u667a\u80fd\u8bbe\u5907,\u66f4\u597d\u7684\u4e86\u89e3\u7528\u6237\uff0c\u4ee5\u4fbf\u63d0\u4f9b\u66f4\u597d\u7684\u670d\u52a1\u3002\u7269\u8054\u7f51\u6b63\u5728\u9010\u6e10\u6539\u53d8\u6211\u4eec\u6240\u719f\u6089\u7684\u751f\u6d3b\u65b9\u5f0f\u3002\u6211\u4eec\u7684\u672a\u6765\u6709\u65e0\u9650\u79cd\u53ef\u80fd\uff0c\u6211\u4eec\u90fd\u88ab\u9080\u8bf7\u6765\u4eab\u53d7\u8fd9\u573a\u901a\u5f80\u66f4\u5149\u660e\u4e16\u754c\u7684\u7f8e\u597d\u65c5\u7a0b!\r\n			</p>\r\n		</div>\r\n	</div>\r\n		\r\n	\r\n<div id=\"footer\">\r\n		<p class=\"right\">Design: \u4e2d\u79d1\u9662\u8054\u5408\u57f9\u517b\u56e2\u961f</p>\r\n		<p>&copy; Copyright 2017 <a href=\"/\">Naling Technology Co. Ltd</a> &middot; All Rights Reserved</p>\r\n</div>\r\n</body>\r\n</html>".toCharArray();
    _jsp_string5 = "><a href=\"#\">\u6848\u4f8b</a></li>\r\n		<li ".toCharArray();
    _jsp_string10 = "\r\n		".toCharArray();
    _jsp_string1 = "\">\r\n<link rel=\"Shortcut Icon\" href=\"/images/windowtree.ico\">\r\n<meta name=\"Keywords\" content=\"\u5185\u5fc3\u7684\u58f0\u97f3\uff0c\u53d1\u73b0\u7f8e\u597d\uff0c\u521b\u9020\u7f8e\u597d\" />\r\n<meta name=\"discription\" content=\"\u542c\u4ece\u81ea\u5df1\u5185\u5fc3\u7684\u58f0\u97f3\uff0c\u53d1\u73b0\u4e16\u754c\u4e0a\u7684\u7f8e\u597d\" />\r\n\r\n	\r\n	<link rel=\"stylesheet\" href=\"/css/main.css\" type=\"text/css\"  />\r\n</head>\r\n\r\n<body>\r\n	".toCharArray();
    _jsp_string6 = "><a href=\"/robot\">\u4e91\u670d\u52a1\u5e73\u53f0</a></li>	\r\n		<li ".toCharArray();
    _jsp_string7 = ">	\r\n		 ".toCharArray();
    _jsp_string3 = " class=\"active\" ".toCharArray();
  }
}
