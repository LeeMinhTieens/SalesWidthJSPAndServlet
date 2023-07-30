<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<script src="<c:url value='/template/famework/jquery.js'/>"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Sản phẩm</title>
</head>
<body>
	<div class="container">
		<div class="row">    
			<div class="col-md-12">
				<form action="<c:url value='/admin/product'/>" id="form-submit" method="GET"> 
					<div class="table-responsive">    
							<a href="<c:url value="/admin/product?type=add" />" class="text-primary ms-3" title="thêm mới sản phẩm">Thêm mới</a>         
							<table id="mytable" class="table table-bordred table-striped">         							
								<thead>    								             
							         <th><input type="checkbox" id="checkall"/> <a href="#" title="xóa" class="text-danger"><i class="bi bi-trash fs-4"></i></a></th>
							         <th>Tên sản phẩm</th>
							         <th>Đánh giá</th>
							         <th>Mô tả ngắn</th>
							         <th>Số lượng có</th>
							         <th>Nội dung</th>
							         <th>Số lượng bán</th>   
							         <th>chỉnh sửa</th>
								</thead>
		    					<tbody>
									<c:forEach items="${PRODUCT}" var ="product">
									    <tr>
										    <td><input type="checkbox" class="checkthis" /></td>
										    <td>${product.getName()}</td>
										    <td>${product.getPrize()}</td>
										    <td>${product.getShortDescription()}</td>
										    <td>${product.getQuantity()}</td>
										    <td style="word-wrap: break-all">${product.getContent()}</td>
										    <td>${product.getSellNumber()}</td>
										    <td><a href="<c:url value='/admin/product?type=edit&id=${product.getId()}'/>" title="Chỉnh sửa"><i class="bi bi-pencil-square bs-bx p-2"></i></a></td>												    
									    </tr>
		    						</c:forEach>
		   						</tbody>     						   
					  		</table>        
	         	 	  </div>    
	         	 	  <input type ="hidden" value = "" id="sortName" name="sortName" />
	         	 	  <input type ="hidden" value = "" id="sortBy" name="sortBy" />
	         	 	  <input type ="hidden" value = "" id="page" name="page" />
	         	 	  <input type ="hidden" value = "" id="limit" name="limit" />
	         	 	  <input type ="hidden" value = "" id="type" name="type" />
	         	</form>  
				         <div class="row mt-3">
							<div class="col-sm-12 ">
								<nav aria-label="Page navigation">
				      				<ul class="pagination" id="pagination"></ul>
				   				</nav>  
							</div>
						</div>   	 	  		 
      	 	</div>
      	 	
		</div>
		
	</div>
	
	
   			
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#mytable #checkall").click(function () {
			        if ($("#mytable #checkall").is(':checked')) {
			            $("#mytable input[type=checkbox]").each(function () {
			                $(this).prop("checked", true);
			            });
	
			        } else {
			            $("#mytable input[type=checkbox]").each(function () {
			                $(this).prop("checked", false);
			            });
			        }
			    });
			    
			    $("[data-toggle=tooltip]").tooltip();
		});
		
		 var totalPage = ${Page.getTotalPage()}
		 var currentPage = ${Page.getPage()}
		 var limit = ${Page.getLimit()}
		 $(function () {
		        window.pagObj = $('#pagination').twbsPagination({
		            totalPages: totalPage,
		            visiblePages: 10,
		            startPage:currentPage,
		            onPageClick: function (event, page) {
		            	if(page != currentPage){
		            		console.log(page);
		            		$('#type').val("list");
		            		$('#sortName').val("name");
		            		$('#sortBy').val("ASC");
		            		$('#page').val(page);
		            		$('#limit').val(limit);
		            		$('#form-submit').submit();	    
		            	}
		                
		            }
		        }).on('page', function (event, page) {
		            console.info(page + ' (from event listening)');
		        });
		    });
		 
		 $(document).ready(function() {
			    $('#form-submit input[type="checkbox"]').click(function() {
			      if ($('#form-submit input[type="checkbox"]:checked').length > 0) {
			        $('#delete').show();
			      } else {
			        $('#delete').hide();
			      }
			    });
		  });
		
	</script>
</body>
</html>