/*
 * JSP generated by Resin-3.1.12 (built Mon, 29 Aug 2011 03:22:08 PDT)
 */

package _jsp._jsp._robot;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;

public class _showrobot__jsp extends com.caucho.jsp.JavaPage
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
    com.caucho.jsp.IteratorLoopSupportTag _jsp_loop_0 = null;
    com.caucho.jsp.IntegerLoopSupportTag _jsp_loop_1 = null;
    try {
      out.write(_jsp_string0, 0, _jsp_string0.length);
      out.print((request.getContextPath()));
      out.write(_jsp_string1, 0, _jsp_string1.length);
      pageContext.pageSetOrRemove("pageType", "platform");
      out.write(_jsp_string2, 0, _jsp_string2.length);
      pageContext.pageSetOrRemove("menuType", "equipdatamenu");
      out.write(_jsp_string3, 0, _jsp_string3.length);
      if (_caucho_expr_0.evalBoolean(_jsp_env)) {
        out.write(_jsp_string4, 0, _jsp_string4.length);
      }
      out.write(_jsp_string5, 0, _jsp_string5.length);
      if (_caucho_expr_1.evalBoolean(_jsp_env)) {
        out.write(_jsp_string4, 0, _jsp_string4.length);
      }
      out.write(_jsp_string6, 0, _jsp_string6.length);
      if (_caucho_expr_2.evalBoolean(_jsp_env)) {
        out.write(_jsp_string4, 0, _jsp_string4.length);
      }
      out.write(_jsp_string7, 0, _jsp_string7.length);
      if (_caucho_expr_3.evalBoolean(_jsp_env)) {
        out.write(_jsp_string4, 0, _jsp_string4.length);
      }
      out.write(_jsp_string8, 0, _jsp_string8.length);
      if (_caucho_expr_4.evalBoolean(_jsp_env)) {
        out.write(_jsp_string9, 0, _jsp_string9.length);
        _caucho_expr_5.print(out, _jsp_env, false);
        out.write(_jsp_string10, 0, _jsp_string10.length);
      }
      out.write(_jsp_string11, 0, _jsp_string11.length);
      if (_caucho_expr_6.evalBoolean(_jsp_env)) {
        out.write(_jsp_string12, 0, _jsp_string12.length);
      }
      out.write(_jsp_string13, 0, _jsp_string13.length);
      if (_caucho_expr_7.evalBoolean(_jsp_env)) {
        out.write(_jsp_string4, 0, _jsp_string4.length);
      }
      out.write(_jsp_string14, 0, _jsp_string14.length);
      if (_caucho_expr_8.evalBoolean(_jsp_env)) {
        out.write(_jsp_string15, 0, _jsp_string15.length);
      }
      out.write(_jsp_string16, 0, _jsp_string16.length);
      if (_caucho_expr_9.evalBoolean(_jsp_env)) {
        out.write(_jsp_string15, 0, _jsp_string15.length);
      }
      out.write(_jsp_string17, 0, _jsp_string17.length);
      if (_caucho_expr_10.evalBoolean(_jsp_env)) {
        out.write(_jsp_string18, 0, _jsp_string18.length);
        if (_jsp_loop_0 == null)
          _jsp_loop_0 = new com.caucho.jsp.IteratorLoopSupportTag();
        java.lang.Object _jsp_items_2 = _caucho_expr_11.evalObject(_jsp_env);
        java.util.Iterator _jsp_iter_2 = com.caucho.jstl.rt.CoreForEachTag.getIterator(_jsp_items_2);
        _jsp_loop_0.init(0, Integer.MAX_VALUE, 1);
        Object _jsp_oldVar_2 = pageContext.getAttribute("item");
        while (_jsp_iter_2.hasNext()) {
          Object _jsp_i_2 = _jsp_iter_2.next();
          pageContext.setAttribute("item", _jsp_i_2);
          _jsp_loop_0.setCurrent(_jsp_i_2, _jsp_iter_2.hasNext());
          out.write(_jsp_string19, 0, _jsp_string19.length);
          _caucho_expr_12.print(out, _jsp_env, false);
          out.write(_jsp_string20, 0, _jsp_string20.length);
          _caucho_expr_13.print(out, _jsp_env, false);
          out.write(_jsp_string20, 0, _jsp_string20.length);
          _caucho_expr_14.print(out, _jsp_env, false);
          out.write(_jsp_string20, 0, _jsp_string20.length);
          _caucho_expr_15.print(out, _jsp_env, false);
          out.write(_jsp_string20, 0, _jsp_string20.length);
          _caucho_expr_16.print(out, _jsp_env, false);
          out.write(_jsp_string20, 0, _jsp_string20.length);
          _caucho_expr_17.print(out, _jsp_env, false);
          out.write(_jsp_string21, 0, _jsp_string21.length);
          _caucho_expr_18.print(out, _jsp_env, false);
          out.write(_jsp_string22, 0, _jsp_string22.length);
        }
        pageContext.pageSetOrRemove("item", _jsp_oldVar_2);
        out.write(_jsp_string23, 0, _jsp_string23.length);
      }
      out.write(_jsp_string23, 0, _jsp_string23.length);
      if (_caucho_expr_19.evalBoolean(_jsp_env)) {
        out.write(_jsp_string24, 0, _jsp_string24.length);
      }
      out.write(_jsp_string25, 0, _jsp_string25.length);
      if (_caucho_expr_20.evalBoolean(_jsp_env)) {
        out.write(_jsp_string26, 0, _jsp_string26.length);
        if (_caucho_expr_21.evalBoolean(_jsp_env)) {
          out.write(_jsp_string27, 0, _jsp_string27.length);
          _caucho_expr_22.print(out, _jsp_env, false);
          out.write(_jsp_string28, 0, _jsp_string28.length);
          _caucho_expr_23.print(out, _jsp_env, false);
          out.write(_jsp_string29, 0, _jsp_string29.length);
        }
        out.write(_jsp_string30, 0, _jsp_string30.length);
        if (_caucho_expr_24.evalBoolean(_jsp_env)) {
          out.write(_jsp_string27, 0, _jsp_string27.length);
          _caucho_expr_22.print(out, _jsp_env, false);
          out.write(_jsp_string31, 0, _jsp_string31.length);
        }
        out.write(_jsp_string30, 0, _jsp_string30.length);
        if (_caucho_expr_25.evalBoolean(_jsp_env)) {
          out.write(_jsp_string27, 0, _jsp_string27.length);
          _caucho_expr_22.print(out, _jsp_env, false);
          out.write(_jsp_string32, 0, _jsp_string32.length);
        }
        out.write(_jsp_string30, 0, _jsp_string30.length);
        if (_jsp_loop_1 == null)
          _jsp_loop_1 = new com.caucho.jsp.IntegerLoopSupportTag();
        int _jsp_begin_3 = (int) _caucho_expr_26.evalLong(_jsp_env);
        int _jsp_end_3 = (int) _caucho_expr_27.evalLong(_jsp_env);
        _jsp_loop_1.init(_jsp_begin_3, _jsp_end_3, 1);
        Object _jsp_status_3 = pageContext.putAttribute("status", _jsp_loop_1);
        for (int _jsp_i_3 = _jsp_begin_3; _jsp_i_3 <= _jsp_end_3; _jsp_i_3 += 1) {
          _jsp_loop_1.setCurrent(_jsp_i_3);
          out.write(_jsp_string33, 0, _jsp_string33.length);
          if (_caucho_expr_28.evalBoolean(_jsp_env)) {
            out.write(_jsp_string34, 0, _jsp_string34.length);
            _caucho_expr_29.print(out, _jsp_env, false);
            out.write(_jsp_string35, 0, _jsp_string35.length);
          }
          out.write(_jsp_string33, 0, _jsp_string33.length);
          if (_caucho_expr_30.evalBoolean(_jsp_env)) {
            out.write(_jsp_string36, 0, _jsp_string36.length);
            _caucho_expr_22.print(out, _jsp_env, false);
            out.write(_jsp_string28, 0, _jsp_string28.length);
            _caucho_expr_29.print(out, _jsp_env, false);
            out.write(_jsp_string37, 0, _jsp_string37.length);
            _caucho_expr_29.print(out, _jsp_env, false);
            out.write(_jsp_string38, 0, _jsp_string38.length);
          }
          out.write(_jsp_string39, 0, _jsp_string39.length);
        }
        pageContext.removeAttribute("status");
        out.write(_jsp_string40, 0, _jsp_string40.length);
        if (_caucho_expr_31.evalBoolean(_jsp_env)) {
          out.write(_jsp_string27, 0, _jsp_string27.length);
          _caucho_expr_22.print(out, _jsp_env, false);
          out.write(_jsp_string28, 0, _jsp_string28.length);
          _caucho_expr_32.print(out, _jsp_env, false);
          out.write(_jsp_string37, 0, _jsp_string37.length);
          _caucho_expr_32.print(out, _jsp_env, false);
          out.write(_jsp_string41, 0, _jsp_string41.length);
        }
        out.write(_jsp_string30, 0, _jsp_string30.length);
        if (_caucho_expr_33.evalBoolean(_jsp_env)) {
          out.write(_jsp_string42, 0, _jsp_string42.length);
          _caucho_expr_22.print(out, _jsp_env, false);
          out.write(_jsp_string28, 0, _jsp_string28.length);
          _caucho_expr_32.print(out, _jsp_env, false);
          out.write(_jsp_string37, 0, _jsp_string37.length);
          _caucho_expr_32.print(out, _jsp_env, false);
          out.write(_jsp_string41, 0, _jsp_string41.length);
        }
        out.write(_jsp_string39, 0, _jsp_string39.length);
        if (_caucho_expr_34.evalBoolean(_jsp_env)) {
          out.write(_jsp_string43, 0, _jsp_string43.length);
          _caucho_expr_22.print(out, _jsp_env, false);
          out.write(_jsp_string28, 0, _jsp_string28.length);
          _caucho_expr_35.print(out, _jsp_env, false);
          out.write(_jsp_string44, 0, _jsp_string44.length);
        }
        out.write(_jsp_string45, 0, _jsp_string45.length);
      }
      out.write(_jsp_string46, 0, _jsp_string46.length);
      out.print((request.getContextPath()));
      out.write(_jsp_string47, 0, _jsp_string47.length);
      out.print((request.getContextPath() ));
      out.write(_jsp_string48, 0, _jsp_string48.length);
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
    _caucho_expr_8 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${menuType==null || menuType == 'equipmenu' }");
    _caucho_expr_9 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${menuType == 'equipdatamenu' }");
    _caucho_expr_10 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${not empty robotOnlineData}");
    _caucho_expr_11 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${robotOnlineData }");
    _caucho_expr_12 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${item.voltage }");
    _caucho_expr_13 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${item.current }");
    _caucho_expr_14 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${item.mode }");
    _caucho_expr_15 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${item.postionX }");
    _caucho_expr_16 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${item.postionY }");
    _caucho_expr_17 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${item.alarmStatus }");
    _caucho_expr_18 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${item.formattedCollectTime }");
    _caucho_expr_19 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${empty robotOnlineData}");
    _caucho_expr_20 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${page.totalPage >1}");
    _caucho_expr_21 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${page.currentPage != 1}");
    _caucho_expr_22 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${page.url }");
    _caucho_expr_23 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${page.currentPage - 1}");
    _caucho_expr_24 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${page.currentPage == 5}");
    _caucho_expr_25 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${page.currentPage > 5}");
    _caucho_expr_26 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${page.startPage}");
    _caucho_expr_27 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${page.endPage}");
    _caucho_expr_28 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${status.current == page.currentPage }");
    _caucho_expr_29 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${status.current}");
    _caucho_expr_30 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${status.current != page.currentPage }");
    _caucho_expr_31 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${page.currentPage + 4 == page.totalPage}");
    _caucho_expr_32 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${page.totalPage}");
    _caucho_expr_33 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${page.currentPage + 4 < page.totalPage}");
    _caucho_expr_34 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${page.totalPage != page.currentPage }");
    _caucho_expr_35 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${page.currentPage + 1}");
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("jsp/robot/showRobot.jsp"), 8375783473691920684L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("jsp/common/common.jsp"), -8798942860517157903L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("jsp/common/header.jsp"), 863675120358004378L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("jsp/common/leftGuide.jsp"), 8214016986163523252L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("jsp/robot/robotData.jsp"), -7719494054062684762L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("jsp/page/pager.jsp"), -3533467289088646575L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("jsp/common/footer.jsp"), 9104851392891087358L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  static {
    try {
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  private static com.caucho.el.Expr _caucho_expr_0;
  private static com.caucho.el.Expr _caucho_expr_1;
  private static com.caucho.el.Expr _caucho_expr_2;
  private static com.caucho.el.Expr _caucho_expr_3;
  private static com.caucho.el.Expr _caucho_expr_4;
  private static com.caucho.el.Expr _caucho_expr_5;
  private static com.caucho.el.Expr _caucho_expr_6;
  private static com.caucho.el.Expr _caucho_expr_7;
  private static com.caucho.el.Expr _caucho_expr_8;
  private static com.caucho.el.Expr _caucho_expr_9;
  private static com.caucho.el.Expr _caucho_expr_10;
  private static com.caucho.el.Expr _caucho_expr_11;
  private static com.caucho.el.Expr _caucho_expr_12;
  private static com.caucho.el.Expr _caucho_expr_13;
  private static com.caucho.el.Expr _caucho_expr_14;
  private static com.caucho.el.Expr _caucho_expr_15;
  private static com.caucho.el.Expr _caucho_expr_16;
  private static com.caucho.el.Expr _caucho_expr_17;
  private static com.caucho.el.Expr _caucho_expr_18;
  private static com.caucho.el.Expr _caucho_expr_19;
  private static com.caucho.el.Expr _caucho_expr_20;
  private static com.caucho.el.Expr _caucho_expr_21;
  private static com.caucho.el.Expr _caucho_expr_22;
  private static com.caucho.el.Expr _caucho_expr_23;
  private static com.caucho.el.Expr _caucho_expr_24;
  private static com.caucho.el.Expr _caucho_expr_25;
  private static com.caucho.el.Expr _caucho_expr_26;
  private static com.caucho.el.Expr _caucho_expr_27;
  private static com.caucho.el.Expr _caucho_expr_28;
  private static com.caucho.el.Expr _caucho_expr_29;
  private static com.caucho.el.Expr _caucho_expr_30;
  private static com.caucho.el.Expr _caucho_expr_31;
  private static com.caucho.el.Expr _caucho_expr_32;
  private static com.caucho.el.Expr _caucho_expr_33;
  private static com.caucho.el.Expr _caucho_expr_34;
  private static com.caucho.el.Expr _caucho_expr_35;

  private final static char []_jsp_string2;
  private final static char []_jsp_string38;
  private final static char []_jsp_string27;
  private final static char []_jsp_string35;
  private final static char []_jsp_string19;
  private final static char []_jsp_string43;
  private final static char []_jsp_string30;
  private final static char []_jsp_string25;
  private final static char []_jsp_string0;
  private final static char []_jsp_string10;
  private final static char []_jsp_string44;
  private final static char []_jsp_string13;
  private final static char []_jsp_string3;
  private final static char []_jsp_string31;
  private final static char []_jsp_string12;
  private final static char []_jsp_string37;
  private final static char []_jsp_string18;
  private final static char []_jsp_string22;
  private final static char []_jsp_string40;
  private final static char []_jsp_string14;
  private final static char []_jsp_string48;
  private final static char []_jsp_string15;
  private final static char []_jsp_string29;
  private final static char []_jsp_string5;
  private final static char []_jsp_string47;
  private final static char []_jsp_string28;
  private final static char []_jsp_string32;
  private final static char []_jsp_string42;
  private final static char []_jsp_string9;
  private final static char []_jsp_string23;
  private final static char []_jsp_string34;
  private final static char []_jsp_string33;
  private final static char []_jsp_string16;
  private final static char []_jsp_string6;
  private final static char []_jsp_string1;
  private final static char []_jsp_string46;
  private final static char []_jsp_string26;
  private final static char []_jsp_string41;
  private final static char []_jsp_string39;
  private final static char []_jsp_string11;
  private final static char []_jsp_string36;
  private final static char []_jsp_string7;
  private final static char []_jsp_string8;
  private final static char []_jsp_string4;
  private final static char []_jsp_string24;
  private final static char []_jsp_string21;
  private final static char []_jsp_string20;
  private final static char []_jsp_string45;
  private final static char []_jsp_string17;
  static {
    _jsp_string2 = "\r\n	".toCharArray();
    _jsp_string38 = "</a>\r\n				".toCharArray();
    _jsp_string27 = "\r\n				<a href=\"".toCharArray();
    _jsp_string35 = "</strong>\r\n				".toCharArray();
    _jsp_string19 = "\r\n								<tr>\r\n									<td>".toCharArray();
    _jsp_string43 = "\r\n	    		<a href=\"".toCharArray();
    _jsp_string30 = "\r\n			".toCharArray();
    _jsp_string25 = "\r\n					</tbody>\r\n				</table>\r\n				\r\n\r\n	\r\n<link rel=\"stylesheet\" href=\"../../css/pager.css\" type=\"text/css\"  />\r\n".toCharArray();
    _jsp_string0 = "\r\n<!DOCTYPE html>\r\n<html>\r\n<head>\r\n<title>\u673a\u5668\u4eba</title>\r\n\r\n<base href=\"".toCharArray();
    _jsp_string10 = "</a>\r\n			<ul style=\"display:none\">\r\n				<li><a href=\"/user/loginOut\">\u767b\u51fa</a></li>\r\n			</ul>\r\n		".toCharArray();
    _jsp_string44 = "\" class=\"next\" rel=\"nofollow\">Next<i class=\"icon\"></i></a>\r\n	    	".toCharArray();
    _jsp_string13 = "	\r\n		</li>\r\n		<li ".toCharArray();
    _jsp_string3 = "\r\n	\r\n<div id=\"header\">\r\n	<div id=\"smallLogo\"></div>\r\n	<ul id=\"menu\">\r\n		<li  ".toCharArray();
    _jsp_string31 = "&page=1\">1</a>\r\n			".toCharArray();
    _jsp_string12 = "\r\n			<a href=\"/user/login\">\u767b\u5f55</a>\r\n		".toCharArray();
    _jsp_string37 = "\">".toCharArray();
    _jsp_string18 = "\r\n							".toCharArray();
    _jsp_string22 = "</td>\r\n				               	</tr>\r\n							".toCharArray();
    _jsp_string40 = "\r\n   			".toCharArray();
    _jsp_string14 = "><a href=\"#\">\u8054\u7cfb\u6211\u4eec</a></li>\r\n	</ul>\r\n</div>\r\n\r\n	<div class=\"dark_space\"></div>\r\n\r\n	<div class=\"content\">\r\n		\r\n<div class=\"container-left\">\r\n			<div class=\"divMenu\" style=\"\">\r\n				<div class=\"headMenuItem\" data-id=\"16\">\r\n					<span> \u8bbe\u5907\u7ba1\u7406 </span> <img src=\"../images/ico_arrow.png\">\r\n				</div>\r\n				<div data-parent-id=\"16\" style=\"\">\r\n					<div class=\"menuItem ".toCharArray();
    _jsp_string48 = "/js/leftNavigation.js\"></script>\r\n</body>\r\n</html>".toCharArray();
    _jsp_string15 = " menuItemActive".toCharArray();
    _jsp_string29 = "\" class=\"prev\" rel=\"nofollow\"><i class=\"icon\">\uf104</i>Previous</a>\r\n			".toCharArray();
    _jsp_string5 = "><a href=\"/\">\u9996\u9875</a></li>\r\n		<li ".toCharArray();
    _jsp_string47 = "/js/jquery-1.9.1.js\"></script>\r\n		<script src=\"".toCharArray();
    _jsp_string28 = "&page=".toCharArray();
    _jsp_string32 = "&page=1\">1</a>\r\n				<strong class=\"omit\">...</strong>\r\n			".toCharArray();
    _jsp_string42 = "\r\n				<strong class=\"omit\">...</strong>\r\n				<a href=\"".toCharArray();
    _jsp_string9 = "\r\n			<a href=\"/user/login\">".toCharArray();
    _jsp_string23 = "\r\n						".toCharArray();
    _jsp_string34 = "\r\n	            	<strong>".toCharArray();
    _jsp_string33 = "\r\n				".toCharArray();
    _jsp_string16 = " \">\r\n						<a href=\"/robot\">\u8bbe\u5907\u5217\u8868</a>\r\n					</div>\r\n					<div class=\"menuItem ".toCharArray();
    _jsp_string6 = "><a href=\"#\">\u6848\u4f8b</a></li>\r\n		<li ".toCharArray();
    _jsp_string1 = "\">\r\n<link rel=\"Shortcut Icon\" href=\"/images/windowtree.ico\">\r\n<meta name=\"Keywords\" content=\"\u5185\u5fc3\u7684\u58f0\u97f3\uff0c\u53d1\u73b0\u7f8e\u597d\uff0c\u521b\u9020\u7f8e\u597d\" />\r\n<meta name=\"discription\" content=\"\u542c\u4ece\u81ea\u5df1\u5185\u5fc3\u7684\u58f0\u97f3\uff0c\u53d1\u73b0\u4e16\u754c\u4e0a\u7684\u7f8e\u597d\" />\r\n\r\n	\r\n<link rel=\"stylesheet\" href=\"../../css/main.css\" type=\"text/css\" />\r\n<link rel=\"stylesheet\" href=\"../../css/list.css\" type=\"text/css\" />\r\n</head>\r\n\r\n<body style=\"font-size: 1em;\">\r\n\r\n	".toCharArray();
    _jsp_string46 = "\r\n\r\n\r\n\r\n			</div>\r\n		</div>\r\n	</div>\r\n\r\n	\r\n<div id=\"footer\">\r\n		<p class=\"right\">Design: \u4e2d\u79d1\u9662\u8054\u5408\u57f9\u517b\u56e2\u961f</p>\r\n		<p>&copy; Copyright 2017 <a href=\"/\">Naling Technology Co. Ltd</a> &middot; All Rights Reserved</p>\r\n</div>\r\n	<script src=\"".toCharArray();
    _jsp_string26 = "\r\n	<div class=\"pager\">\r\n		<div class=\"page-num\">\r\n			".toCharArray();
    _jsp_string41 = "</a>\r\n			".toCharArray();
    _jsp_string39 = "\r\n	    	".toCharArray();
    _jsp_string11 = "\r\n		".toCharArray();
    _jsp_string36 = "\r\n				 	<a href=\"".toCharArray();
    _jsp_string7 = "><a href=\"/robot\">\u4e91\u670d\u52a1\u5e73\u53f0</a></li>	\r\n		<li ".toCharArray();
    _jsp_string8 = ">	\r\n		 ".toCharArray();
    _jsp_string4 = " class=\"active\" ".toCharArray();
    _jsp_string24 = "\r\n							<tr><td  colspan=\"7\" align=\"center\">\u6682\u65e0\u6570\u636e</td></tr>\r\n						".toCharArray();
    _jsp_string21 = "</td>\r\n				               		<td>".toCharArray();
    _jsp_string20 = "</td>\r\n									<td>".toCharArray();
    _jsp_string45 = "\r\n		</div>\r\n	</div>\r\n".toCharArray();
    _jsp_string17 = " \">\r\n						<a href=\"/search\">\u6570\u636e\u67e5\u8be2</a>\r\n					</div>\r\n				</div>\r\n				<div class=\"headMenuItem\" data-id=\"33\">\r\n					<span> \u4e2a\u4eba\u4e2d\u5fc3 </span> <img src=\"../images/ico_arrow.png\">\r\n				</div>\r\n				<div data-parent-id=\"33\" style=\"display: none;\">\r\n					<div class=\"menuItem\">\r\n						<a href=\"#\">\u4fee\u6539\u5bc6\u7801</a>\r\n					</div>\r\n					<div class=\"menuItem\">\r\n						<a href=\"#\">\u6211\u7684\u8d44\u6599</a>\r\n					</div>\r\n					<div class=\"menuItem\">\r\n						<a href=\"#\">\u65e5\u5fd7\u4fe1\u606f</a>\r\n					</div>\r\n				</div>\r\n			</div>\r\n		</div>\r\n		\r\n		<div class=\"container-right\">\r\n\r\n			<div class=\"divContent\">\r\n				<div class=\"divNav\">\r\n					\u5f53\u524d\u4f4d\u7f6e\uff1a <a href=\"/robot\">\u8bbe\u5907\u7ba1\u7406</a> &gt;&gt; \u6570\u636e\u67e5\u8be2\r\n				</div>\r\n				<div class=\"divQuery pull-right\">\r\n					<a href=\"/robot\">\u8fd4\u56de</a>\r\n				</div>\r\n				\r\n\r\n				<table class=\"table table-hover table-gray\">\r\n					<tbody>\r\n						<tr>\r\n							<th>\u7535\u538b</th>\r\n							<th>\u7535\u6d41</th>\r\n							<th>\u5de5\u4f5c\u6a21\u5f0f</th>\r\n							<th>\u673a\u5668\u4eba\u4f4d\u7f6eX(mm)</th>\r\n							<th>\u673a\u5668\u4eba\u4f4d\u7f6eY(mm)</th>\r\n							<th>\u62a5\u8b66\u72b6\u6001</th>\r\n							<th>\u65f6\u95f4</th>\r\n						</tr>\r\n						".toCharArray();
  }
}
