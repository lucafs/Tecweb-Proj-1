<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

/* Add a background color when the inputs get focus */
input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for all buttons */
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

button:hover {
  opacity:1;
}

/* Extra styles for the cancel button */
.cancelbtn {
  padding: 14px 20px;
  background-color: #f44336;
}

</style>
<body>

<h2>Login Aplicativo de Notas</h2>

<button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Criar Conta</button>
<button onclick="document.getElementById('id02').style.display='block'" style="width:auto;">Logar em Conta</button>

<div id="id01" class="modal">
  <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
  <form class="modal-content" action="/action_page.php">
    <div class="container">
      <h1>Sign Up</h1>
      <p>Cria Conta.</p>
      <hr>
      <label for="user"><b>Usuario</b></label>
      <input type="text" placeholder="Usuario" name="user" required>

      <label for="senha"><b>Senha</b></label>
      <input type="password" placeholder="Senha" name="senha" required>

      <div class="clearfix">
        <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
        <button type="submit" class="signupbtn">Sign Up</button>
      </div>
    </div>
  </form>
</div>


<div id="id02" class="modal">
  <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
  <form class="modal-content" action="/action_page.php">
    <div class="container">
      <h1>Logar</h1>
      <p>Logar em Conta.</p>
      <hr>
      <label for="user"><b>Usuario</b></label>
      <input type="text" placeholder="Usuario" name="user" required>

      <label for="senha"><b>Senha</b></label>
      <input type="password" placeholder="Senha" name="senha" required>

      <div class="clearfix">
        <button type="button" onclick="document.getElementById('id02').style.display='none'" class="cancelbtn">Cancel</button>
        <button type="submit" class="signupbtn">Logar</button>
      </div>
    </div>
  </form>
</div>

<script>
// Get the modal
var modal = document.getElementById('id01');
var modal2 = document.getElementById('id02');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal ) {
    modal.style.display = "none";
  }
  if (event.target == modal2 ) {
	    modal2.style.display = "none";
 }
}
</script>

</body>
</html>
</body>
</html>