<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<s:head />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户注册</title>
<script type="text/JavaScript" src="js/jquery.js"></script>
<script type="text/JavaScript" src="js/user.js"></script>
<script type="text/JavaScript" src="js/register.js"></script>
<script type="text/JavaScript">
	function MM_preloadImages() { //v3.0
		var d = document;
		if (d.images) {
			if (!d.MM_p)
				d.MM_p = new Array();
			var i, j = d.MM_p.length, a = MM_preloadImages.arguments;
			for (i = 0; i < a.length; i++)
				if (a[i].indexOf("#") != 0) {
					d.MM_p[j] = new Image;
					d.MM_p[j++].src = a[i];
				}
		}
	}
	//-->
</script>
<link href="css/css.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
#Layer1 {
	position: absolute;
	left: 225px;
	top: 11px;
	width: 154px;
	height: 54px;
	z-index: 1;
}

body {
	margin-left: 00px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<body>
<form action="userAction_addUser.action" method="post" id="registerForm">
<table width="100%" height="610%" border="0" cellpadding="0"
	cellspacing="0">
	<tr>
		<td height="28" valign="top" background="images/loginbg.gif">
		<table width="676" height="284" border="0" align="center"
			cellpadding="0" cellspacing="0">
			<tr>
				<td height="84" align="left">
				<table width="237" height="39" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td align="right" bgcolor="#FFFFFF"><img
							src="images/logo.gif" width="226" height="62" /></td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td>
				<table id="__01" width="785" height="125" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td height="30"><img src="images/login1_01.gif" width="785"
							height="30" alt="" /></td>
					</tr>
					<tr>
						<td height="18" background="images/login1_02.gif">
						<table width="728" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="361" align="left">
								<table width="354" height="198" border="0" cellpadding="0"
									cellspacing="0">
									<tr>
										<td height="30" valign="top" class="henhong">
										<table width="350" height="40" border="0" cellpadding="0"
											cellspacing="0">
											<tr>
												<td width="350" valign="top">用户名称：<br />
												<input name="user.userName" type="text" size="30"
													id="userName" /> <br />
												<span class="huise1">登录昵称为4-15个字符之间，用来区分注册用户，要求彼此不同</span></td>
											</tr>
											<tr>
												<td width="350" valign="top">密码：<br />
												<input name="user.password" type="password" size="30"
													id="password" /> <br />
												<span class="huise1">密码为6-15个字符之间</span></td>
											</tr>
											<tr>
												<td width="350" valign="top">确认密码：<br />
												<input name="confirmPassword" type="password" size="30"
													id="confirmPassword" /> <br />
												<span class="huise1">密码为6-15个字符之间,必须与密码一致</span></td>
											</tr>
											<tr>
												<td width="350" valign="top">性别： 男<input type="radio"
													name="user.sex" checked value="男" /> 女<input type="radio"
													name="user.sex" value="女" /><br />
												<span class="huise1">选择“男”或者“女”</span></td>
											</tr>
											<tr>
												<td width="350" valign="top">出生年月：<br />
												<input name="user.birthday" type="text" size="30" /> <br />
												<span class="huise1">请选择出生年月</span></td>
											</tr>
											<tr>
												<td width="350" valign="top">联系电话：<br />
												<input name="user.tel" type="text" size="30" /> <br />
												<span class="huise1">填写联系电话，方便联系你</span></td>
											</tr>
											<tr>
												<td width="350" valign="top">电子邮件：<br />
												<input name="user.email" type="text" size="30" /> <br />
												<span class="huise1">填写电子邮件，方便联系你</span></td>
											</tr>
											<tr>
												<td width="350" valign="top">条款：<br />
												<textarea rows="9" cols="45" style="margin-bottom: 6px;"
													readOnly="true" id="item">
												</textarea> <span class="huise1">&nbsp;</span></td>
											</tr>
										</table>
										<table width="332" height="40" border="0" cellpadding="0"
											cellspacing="0">
											<tr>
												<td align="center" valign="top"><img
													src="images/btn_register.gif" width="302" height="36"
													onclick="register('registerForm')" style="cursor: hand;" /></td>
											</tr>
										</table>
										</td>
									</tr>
								</table>
								</td>
								<td width="367" align="left" valign="top"><img
									src="images/zhuce.jpg" width="367" height="229" /></td>
							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td height="39"><img src="images/login1_03.gif" width="785"
							height="39" alt="" /></td>
					</tr>
					<tr>
						<td height="38" background="images/login1_04.gif">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span
							class="huise1">(C) 1999-2010吉林省明日科技有限公司</span></td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td align="center">&nbsp;</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>
