<%-- 
    Document   : repsd
    Created on : 2018-9-6, 14:09:55
    Author     : ZJX
--%>

<%@ page language="java" import="java.util.*,serve.user" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/normalize.css" rel="stylesheet"/>
<link href="css/jquery-ui.css" rel="stylesheet"/>
<link href="css/jquery.idealforms.min.css" rel="stylesheet" media="screen"/>

<style type="text/css">
body{font:normal 15px/1.5 Arial, Helvetica, Free Sans, sans-serif;color: #222;background:url(pattern.png);overflow-y:scroll;padding:60px 0 0 0;}
#my-form{width:755px;margin:0 auto;border:1px solid #ccc;padding:3em;border-radius:3px;box-shadow:0 0 2px rgba(0,0,0,.2);}
#comments{width:350px;height:100px;}
</style>
    </head>
    <body>
        <%
           // session.setAttribute("name", "ui");
            //HttpSession session = request.getSession();
            String s = (String)session.getAttribute("user");
            //String s ="ui";
            user u = new user();
                  //u.setName((String)session.getAttribute("user"));
                  //u=u.getallinfo((String)session.getAttribute("user"));
             u = u.getallinfo(s);
            %>
        <div class="row">

  <div class="eightcol last">

    <!-- Begin Form -->

    <div  id="my-form">
        
        
        <section name="个人信息">
            <div><label>用户名:</label><h3><%=u.getloginid()%></h3></div>
            <div><label>地址：</label><h3><%=u.getAddr()%></h3></div>
            <div><label>邮件地址：</label><h3><%=u.getEmail()%></h3></div>
            <div><label>电话号码:</label><h3><%=u.getPhone()%></h3></div>
            <!--
          <div><label>国籍:</label>
          <select id="states" name="states">
            <option value="default">&ndash; 选择国籍 &ndash;</option>
            <option value="AL">阿拉伯</option>
            <option value="AK">中国</option>
            <option value="AZ">美国</option>
            <option value="AR">法国</option>
            <option value="CA">英国</option>
            <option value="CO">德国</option>
            <option value="CT">西班牙</option>
            <option value="DE">俄罗斯</option>
          </select>
        </div>
        <div><label>邮编:</label><input type="text" name="zip" data-ideal="zip"/></div>
        <div><label>备注:</label><textarea id="comments" name="comments"></textarea></div>
        -->
      </section>
        

        <section name="修改密码">

            <form action="reinfo" method="post" id="form1">
              <input name="op" type="hidden" value="pwd"/>
           <input name="user" type="hidden" value='<%= s %>'  />
          <div><label>请输入旧密码：</label><input id="psd0" name="oldpsd" type="password"/></div>
          <div><label>请输入新密码</label><input id="psd1" name="newpsd" type="password"/></div>
          <div><label>请再次输入新密码</label><input id="psd2" name="rnewpsd" type="password"/></div>
<!--          <div><input  value='确定' type="submit"/></div>-->
         <div><button id="reset1" type="button" onClick="panduan();">确定</button></div>
           </form>
        </section>

        <section name="修改其他信息">
          
          <div id="languages">
                  <form action="reinfo" method='post'>
                  <table>
                      <tr><td><div><label>旧用户名:<%=u.getloginid()%></label>
                                         </div>
                          </td>
                          <td><div><label><input type="text" name="loginid" value="<%=u.getloginid()%>"/></label></div></td></tr>
                      <tr><td><div><label>旧地址:<%=u.getAddr()%></label></div></td>
                          <td><div><label><input type="text" name="addr" value="<%=u.getAddr()%>"/></label></div></td></tr>
                      <tr>
                          <td>
                <div><label>旧电话号码:<%=u.getPhone()%></label></div>
                          </td>
                          <td>
                <div><label><input type="text" name="phone" value="<%=u.getPhone()%>"/></label></div>
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <div><label>旧邮件地址:<%=u.getEmail()%></label></div>
                          </td>
                          <td>
                              <div><label><input type="text" name="email" value="<%=u.getEmail()%>"/></label></div>
                  
                          </td>
                      </tr>
                      </table>
                      <div><input name="user" type="hidden" value='<%= s %>'  /></div>
                      <div><input name="op" type="hidden" value='xinxi' /></div>
<!--                      <div><input name="sub" type="submit" value='确定' /></div>-->
                <div><label></label><button id="reset1" type="button" onClick="submit();">确定</button></div>
                  </form>
          </div>
          <!--
          <div><label>精通几门:</label>
            <label><input type="radio" name="radio" checked/>1</label>
            <label><input type="radio" name="radio"/>2</label>
            <label><input type="radio" name="radio"/>3</label>
            <label><input type="radio" name="radio"/>4</label>
          </div>
          -->
            
        </section>
<!--
        <section name="第三步">
          <div><label>电话:</label><input type="tel" name="phone" data-ideal="phone"/></div>
          <div><label>国籍:</label>
          <select id="states" name="states">
            <option value="default">&ndash; 选择国籍 &ndash;</option>
            <option value="AL">阿拉伯</option>
            <option value="AK">中国</option>
            <option value="AZ">美国</option>
            <option value="AR">法国</option>
            <option value="CA">英国</option>
            <option value="CO">德国</option>
            <option value="CT">西班牙</option>
            <option value="DE">俄罗斯</option>
          </select>
        </div>
        <div><label>邮编:</label><input type="text" name="zip" data-ideal="zip"/></div>
        <div><label>备注:</label><textarea id="comments" name="comments"></textarea></div>
      </section>
-->
      <div><hr/></div>

<!--      <div>
        <button type="submit">提交</button>
        <button id="reset" type="button">重置</button>
      </div>-->
      
    </div>

    <!-- End Form -->

  </div>

</div>


<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript" src="js/jquery.idealforms.js"></script>
<script type="text/javascript">
    function submit(){

//if(confirm('确定删除选中的咨询吗?\n注意，删除后无法恢复！')){

//this.form.action="UserReview.asp?action=delall" //设置处理程序

this.form.submit(); //提交表单

}



    function panduan()
{
var mima1=document.getElementById("psd1").value
//取出第一个文本框里输如的值密码一
var mima2=document.getElementById("psd2").value
//取出第二个文本框里输如的值密码二
if(mima1==mima2)
//2个值比较，做判断
{
//alert("2个密码一样拉")
 document.getElementById('form1').submit();
//输出对话框提示
//document.getElementById("mima1").focus()
//焦点定位
}
else
//否则
{
alert("密码和密码确认不同，请重新输入")
//输出对话框提示
document.getElementById("mima1").focus()
//焦点定位
}
}


var options = {

	onFail: function(){
		alert( $myform.getInvalid().length +' invalid fields.' )
	},

	inputs: {
		'password': {
			filters: 'required pass',
		},
		'username': {
			filters: 'required username',
			data: {
			//ajax: { url:'validate.php' }
			}
		},
		'file': {
			filters: 'extension',
			data: { extension: ['jpg'] }
		},
		'comments': {
			filters: 'min max',
			data: { min: 50, max: 200 }
		},
		'states': {
			filters: 'exclude',
			data: { exclude: ['default'] },
			errors : {
				exclude: '选择国籍.'
			}
		},
		'langs[]': {
			filters: 'min max',
			data: { min: 2, max: 3 },
			errors: {
				min: 'Check at least <strong>2</strong> options.',
				max: 'No more than <strong>3</strong> options allowed.'
			}
		}
	}
	
};



var $myform = $('#my-form').idealforms(options).data('idealforms');

$('#reset').click(function(){
	$myform.reset().fresh().focusFirst()
});

$myform.focusFirst();

</script>
<div style="text-align:center;">
    <p>用户信息详情及修改页面<a href="main.jsp">前往主页</a></p>
</div>
    </body>
</html>
