<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file = "/common/taglib.jsb" %>
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Sản phẩm</title>
</head>
<body>
	<div class="container">
		<div class="row">    
			<div class="col-md-12">
				<div class="table-responsive">             
					<table id="mytable" class="table table-bordred table-striped">         
						<thead>                  
					         <th><input type="checkbox" id="checkall"/></th>
					         <th>First Name</th>
					         <th>Last Name</th>
					         <th>Address</th>
					         <th>Email</th>
					         <th>Contact</th>
					         <th>Edit</th>           
					         <th>Delete</th>
						</thead>
    					<tbody>
    
						    <tr>
							    <td><input type="checkbox" class="checkthis" /></td>
							    <td>Mohsin</td>
							    <td>Irshad</td>
							    <td>CB 106/107 Street # 11 Wah Cantt Islamabad Pakistan</td>
							    <td>isometric.mohsin@gmail.com</td>
							    <td>+923335586757</td>
							    <td><p data-placement="top" data-toggle="tooltip" title="Edit"><button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>
							    <td><p data-placement="top" data-toggle="tooltip" title="Delete"><button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p></td>
						    </tr>
    
							<tr>
							    <td><input type="checkbox" class="checkthis" /></td>
							    <td>Mohsin</td>
							    <td>Irshad</td>
							    <td>CB 106/107 Street # 11 Wah Cantt Islamabad Pakistan</td>
							    <td>isometric.mohsin@gmail.com</td>
							    <td>+923335586757</td>
							    <td><p data-placement="top" data-toggle="tooltip" title="Edit"><button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>
							    <td><p data-placement="top" data-toggle="tooltip" title="Delete"><button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p></td>
							</tr>
							    
							    
							<tr>
								    <td><input type="checkbox" class="checkthis" /></td>
								    <td>Mohsin</td>
								    <td>Irshad</td>
								    <td>CB 106/107 Street # 11 Wah Cantt Islamabad Pakistan</td>
								    <td>isometric.mohsin@gmail.com</td>
								    <td>+923335586757</td>
								    <td><p data-placement="top" data-toggle="tooltip" title="Edit"><button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>
								    <td><p data-placement="top" data-toggle="tooltip" title="Delete"><button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p></td>
    						</tr>
    
    
    
							<tr>
								    <td><input type="checkbox" class="checkthis" /></td>
								    <td>Mohsin</td>
								    <td>Irshad</td>
								    <td>CB 106/107 Street # 11 Wah Cantt Islamabad Pakistan</td>
								    <td>isometric.mohsin@gmail.com</td>
								    <td>+923335586757</td>
								    <td><p data-placement="top" data-toggle="tooltip" title="Edit"><button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>
								    <td><p data-placement="top" data-toggle="tooltip" title="Delete"><button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p></td>
							 </tr>
    
    
							 <tr>
							    <td><input type="checkbox" class="checkthis" /></td>
							    <td>Mohsin</td>
							    <td>Irshad</td>
							    <td>CB 106/107 Street # 11 Wah Cantt Islamabad Pakistan</td>
							    <td>isometric.mohsin@gmail.com</td>
							    <td>+923335586757</td>
							    <td><p data-placement="top" data-toggle="tooltip" title="Edit"><button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>
							    <td><p data-placement="top" data-toggle="tooltip" title="Delete"><button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p></td>
							    </tr>
   						</tbody>      
				  	</table>                
         	 	  </div>
      	 	</div>
		</div>
	</div>
</body>
</html>