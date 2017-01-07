package Actions;

import Modelos.Cliente;
import Modelos.Direccion;
import Modelos.Empresa;
import Modelos.Usuario;
import java.sql.*;
import java.util.Date;
public class Conexion {

    //********************* Atributos *************************
    private java.sql.Connection Conex;
    //Atributo a través del cual hacemos la conexión física.
    private java.sql.Statement Sentencia_SQL;
    //Atributo que nos permite ejecutar una sentencia SQL
    private java.sql.ResultSet Conj_Registros;
    private java.sql.ResultSet aux_Conj_Registros;
    //(Cursor) En él están almacenados los datos.
    private String bbdd;
    private String usuario;
    private String clave;

    //********************** Constructores **************************
    //----------------------------------------------------------
    public Conexion() throws ClassNotFoundException,
            InstantiationException, IllegalAccessException, SQLException {
        //Cargar el driver/controlador
        String controlador = "com.mysql.jdbc.Driver";
        //String controlador = "oracle.jdbc.driver.OracleDriver";
        //String controlador = "sun.jdbc.odbc.JdbcOdbcDriver";
        Class.forName(controlador).newInstance();

        Conectar("ejemplo");
    }

    public Conexion(String b, String u, String c) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException, SQLException {
        //Cargar el driver/controlador
        String controlador = "com.mysql.jdbc.Driver";
        //String controlador = "oracle.jdbc.driver.OracleDriver";
        //String controlador = "sun.jdbc.odbc.JdbcOdbcDriver";
        Class.forName(controlador).newInstance();
        bbdd = b;
        usuario = u;
        clave = c;
        Conectar(bbdd);
    }

    //********************** Métodos **************************
    //----------------------------------------------------------
    private void Conectar(String nombre_bbdd) throws SQLException {
        String URL_BD = "jdbc:mysql://localhost/" + nombre_bbdd;
        //String URL_BD = "jdbc:oracle:oci:@REPASO";
        //String URL_BD = "jdbc:oracle:oci:@REPASO";
        //String URL_BD = "jdbc:odbc:REPASO";

        //Realizamos la conexión a una BD con un usuario y una clave.
        try {
            Conex = java.sql.DriverManager.getConnection(URL_BD, usuario, clave);
            Sentencia_SQL = Conex.createStatement();
            System.out.println("Conexion realizada con éxito");
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }

    }

    //------------------------Métodos Auxiliares----------------------------------
    public void Obtener_Datos_Tabla(String nom_tabla) throws SQLException {
        String Sentencia = "SELECT * FROM " + nom_tabla;
        Conj_Registros = Sentencia_SQL.executeQuery(Sentencia);
    }

    //----------------------------------------------------------
    private void Mostrar_Fila_Actual() throws SQLException {
        int i, Num_Cols;

        Num_Cols = Conj_Registros.getMetaData().getColumnCount();
        for (i = 1; i <= Num_Cols; i++) {
            System.out.println(Conj_Registros.getString(i));
        }
    }

    //----------------------------------------------------------
    public void Mostrar_Tabla(String tabla) throws SQLException {
        Obtener_Datos_Tabla(tabla);

        //Conj_Registros.first();
        while (Conj_Registros.next()) {
            Mostrar_Fila_Actual();
        }
    }

    //----------------------------------------------------------
    public void Modificar_Dato(String tabla, String DNI, String Nuevo_Nombre) throws SQLException {
        String Sentencia = "UPDATE " + tabla + " SET Nombre = '" + Nuevo_Nombre + "' WHERE DNI = '" + DNI + "'";
        Sentencia_SQL.executeUpdate(Sentencia);
    }

    //----------------------------------------------------------
    public void Insertar_Dato(String tabla, String DNI, String Nombre, String apell, int Tfno, int avi) throws SQLException {

        String Sentencia = "INSERT INTO " + tabla + " VALUES ('" + DNI + "'," + "'" + Nombre + "','" + apell + "','" + Tfno + "','" + avi + "')";
        Sentencia_SQL.executeUpdate(Sentencia);
    }

    //----------------------------------------------------------
    public String Insertar_Dato(String tabla, String DNI, String Nombre, int Tfno) throws SQLException {

        String Sentencia = "INSERT INTO " + tabla + " VALUES ('" + DNI + "'," + "'" + Nombre + "','" + Tfno + "')";
        Sentencia_SQL.executeUpdate(Sentencia);
        return Sentencia;
    }

    //----------------------------------------------------------
    public void Borrar_Dato(String tabla, String DNI) throws SQLException {
        String Sentencia = "DELETE FROM " + tabla + " WHERE DNI = '" + DNI + "'";
        Sentencia_SQL.executeUpdate(Sentencia);
    }

    //------------------------------------------------------
    public String Obtener_Primero(String Campo) throws SQLException {
        String valor;

        //Conj_Registros.first();
        Conj_Registros.next();
        valor = Conj_Registros.getString(Campo);
        return valor;
    }

    //------------------------------------------------------
    public String Obtener_Ultimo(String Campo) throws SQLException {
        String valor;

        //Conj_Registros.last();
        Conj_Registros.previous();
        valor = Conj_Registros.getString(Campo);
        return valor;
    }

    //------------------------------------------------------
    public String Obtener_Actual(String Campo) throws SQLException {
        String valor;

        valor = Conj_Registros.getString(Campo);
        return valor;
    }

    public int Obtener_ID_Actual(String Campo) throws SQLException {
        int valor;
        valor = Conj_Registros.getInt(Campo);
        return valor;
    }
 

    //------------------------------------------------------
    public boolean Obtener_Siguiente() throws SQLException {
        return Conj_Registros.next();
    }
    

    //------------------------------------------------------
    public boolean Obtener_Anterior() throws SQLException {
        return Conj_Registros.previous();
    }

    //------------------------------------------------------
    public void Vaciar_Tabla(String tabla) throws SQLException {
        String sentencia = "TRUNCATE " + tabla;
        Sentencia_SQL.executeUpdate(sentencia);
    }

   public String Obtener_Primer(String Campo) throws SQLException {
        String valor;

        Conj_Registros.first();
        valor = Conj_Registros.getString(Campo);
        return valor;
    }
    //-------------------Métodos de la aplicación--------------------------//

    //-------------------Mantenimiento de categorías-------------------//
    public void getAllCategoria() throws SQLException {
        String sentencia = "SELECT ID, NOMBRE FROM CATEGORIA";
        Conj_Registros = Sentencia_SQL.executeQuery(sentencia);
    }

    public void getCategoria(int id) throws SQLException {
        String sentencia = "SELECT NOMBRE FROM CATEGORIA WHERE id = '" + id + "'";
        Conj_Registros = Sentencia_SQL.executeQuery(sentencia);
    }
     public void getCategoria(String nombre) throws SQLException {
        String sentencia = "SELECT ID FROM CATEGORIA WHERE NOMBRE = '" + nombre + "'";
        Conj_Registros = Sentencia_SQL.executeQuery(sentencia);
    }

    public void InsertarCategoria(String nombre) throws SQLException {
      
       
            String sentencia = "INSERT INTO CATEGORIA VALUES(NULL, '" + nombre + "')";
            Sentencia_SQL.executeUpdate(sentencia);
        
    }

    public void ModificarCategoria(int id, String nombre) throws SQLException {
        String sentencia = "UPDATE CATEGORIA SET NOMBRE ='" + nombre + "' WHERE ID = '" + id + "'";
        Sentencia_SQL.executeUpdate(sentencia);
    }

    public void BorrarCategoria(int id) throws SQLException {
        String sentencia = "DELETE FROM CATEGORIA WHERE ID =  '" + id + "'";
        Sentencia_SQL.executeUpdate(sentencia);
    }
    //-----------------------------Mantenimiento de subcategorías---------------//

    
    public void getSubCategoria(int id) throws SQLException {
        String sentencia = "SELECT ID, ID_CATEGORIA, NOMBRE FROM SUBCATEGORIA WHERE ID_CATEGORIA = '" + id + "'";
        Conj_Registros = Sentencia_SQL.executeQuery(sentencia);
    }
     public void getSubCategoria(String nombre) throws SQLException {
        String sentencia = "SELECT ID, ID_CATEGORIA, NOMBRE FROM SUBCATEGORIA WHERE NOMBRE = '" + nombre+ "'";
        Conj_Registros = Sentencia_SQL.executeQuery(sentencia);
    }

    public void getAllSubCategoria() throws SQLException {
        String sentencia = "SELECT ID, ID_CATEGORIA, NOMBRE FROM SUBCATEGORIA";
        Conj_Registros = Sentencia_SQL.executeQuery(sentencia);
    }
    

    public void InsertarSubCategoria(String nombreCat, String nombre) throws SQLException {
        this.getCategoria(nombreCat);
        if (this.Obtener_Siguiente()) {
            String sentencia = "INSERT INTO SUBCATEGORIA VALUES(NULL,'" + Obtener_ID_Actual("ID") + "', '" + nombre + "')";
            Sentencia_SQL.executeUpdate(sentencia);
        }
    }

    public void ModificarSubCategoria(int id, String nombreCat, String nombre) throws SQLException {
        getCategoria(nombreCat);
          String sentencia = "";
        if(Obtener_Siguiente()){             
            sentencia = "UPDATE SUBCATEGORIA SET ID_CATEGORIA ='" + Obtener_ID_Actual("ID") + "', NOMBRE ='" + nombre + "' WHERE ID = '" + id + "'";                           
        }
        else{          
            sentencia = "UPDATE SUBCATEGORIA SET NOMBRE ='" + nombre + "' WHERE ID = '" + id + "'";       
        }
        Sentencia_SQL.executeUpdate(sentencia);
    }

    public void BorrarSubCategoria(int id) throws SQLException {
        String sentencia = "DELETE FROM SUBCATEGORIA WHERE ID ='" + id + "'";
        Sentencia_SQL.executeUpdate(sentencia);
    }
    //-----------------------Administración de productos---------------------------//
    
    public void InsertarProducto(String REF, String nombre, String desc, 
            String nombreCat, String nombreSubCat,int precio1,int precio2,
             String ficha, String imagen) throws SQLException{
        int idCat=0, idSubCat=0;
         this.getCategoria(nombreCat);
         if(this.Obtener_Siguiente()){
             idCat = this.Obtener_ID_Actual("ID");
         }
         this.getSubCategoria(nombreSubCat);
        if(this.Obtener_Siguiente()){
            idSubCat = this.Obtener_ID_Actual("ID");
        }
        String sentencia="INSERT INTO PRODUCTO VALUES('"+ REF+"','"+nombre+
                "','"+desc+"',"+idCat+","+idSubCat+","+precio1+
                ","+precio2+",'"+ficha+"','"+imagen+"' )";
        Sentencia_SQL.executeUpdate(sentencia);
    }
    public void BorrarProducto(String REF) throws SQLException{
        String sentencia = "DELETE FROM PRODUCTO WHERE REF = '"+REF+"'";
       Sentencia_SQL.executeUpdate(sentencia);
    }
    public void GetAllProducto() throws SQLException{
    
        String sentencia = "SELECT REF, NOMBRE, DESCRIPCION, ID_CATEGORIA, ID_SUBCATEGORIA, PRECIO1, PRECIO2, FICHA, IMAGEN FROM PRODUCTO";
        Conj_Registros = Sentencia_SQL.executeQuery(sentencia);
        
}
    public void GetProducto(String REF) throws SQLException{
        String sentencia = "SELECT REF, NOMBRE, DESCRIPCION, ID_CATEGORIA, ID_SUBCATEGORIA, PRECIO1, PRECIO2, FICHA, IMAGEN FROM PRODUCTO WHERE REF = '"+REF+"'";
        Conj_Registros = Sentencia_SQL.executeQuery(sentencia);
    }
    
    public void ModificarProducto(String REF, String nombre, String desc, 
            String nombreCat, String nombreSubCat,int precio1,int precio2,
             String ficha, String imagen) throws SQLException{
        String sentencia="";
        int idCat=0, idSubCat=0;
         this.getCategoria(nombreCat);
         if(this.Obtener_Siguiente()){
             idCat = this.Obtener_ID_Actual("ID");
         }
         this.getSubCategoria(nombreSubCat);
        if(this.Obtener_Siguiente()){
            idSubCat = this.Obtener_ID_Actual("ID");
        }
        if (ficha!=null && imagen!=null){
        sentencia ="UPDATE PRODUCTO SET NOMBRE = '"+nombre+"', "
                                            + "DESCRIPCION = '"+desc+"',"
                                            + "ID_CATEGORIA = "+idCat+","
                                            + "ID_SUBCATEGORIA = "+idSubCat+","
                                            + "PRECIO1 = "+precio1+","
                                            + "PRECIO2 = "+precio2+","
                                            + "FICHA = '"+ficha+"',"
                                            + "IMAGEN = '"+imagen+"'"
                            + "WHERE REF = '"+REF+"'";
        }
        if(ficha!=null && imagen==null){
             sentencia ="UPDATE PRODUCTO SET NOMBRE = '"+nombre+"', "
                                            + "DESCRIPCION = '"+desc+"',"
                                            + "ID_CATEGORIA = "+idCat+","
                                            + "ID_SUBCATEGORIA = "+idSubCat+","
                                            + "PRECIO1 = "+precio1+","
                                            + "PRECIO2 = "+precio2+","
                                            + "FICHA = '"+ficha+"'"
                            + "WHERE REF = '"+REF+"'";
        }
        if(ficha==null && imagen!=null){
             sentencia ="UPDATE PRODUCTO SET NOMBRE = '"+nombre+"', "
                                            + "DESCRIPCION = '"+desc+"',"
                                            + "ID_CATEGORIA = "+idCat+","
                                            + "ID_SUBCATEGORIA = "+idSubCat+","
                                            + "PRECIO1 = "+precio1+","
                                            + "PRECIO2 = "+precio2+","
                                            
                                            + "IMAGEN = '"+imagen+"'"
                            + "WHERE REF = '"+REF+"'";
        }
        if(ficha==null && imagen==null){
            sentencia ="UPDATE PRODUCTO SET NOMBRE = '"+nombre+"', "
                                            + "DESCRIPCION = '"+desc+"',"
                                            + "ID_CATEGORIA = "+idCat+","
                                            + "ID_SUBCATEGORIA = "+idSubCat+","
                                            + "PRECIO1 = "+precio1+","
                                            + "PRECIO2 = "+precio2+","
                                            
                                           
                            + "WHERE REF = '"+REF+"'";
        }
        Sentencia_SQL.executeUpdate(sentencia);
    }

    //-----------------------Login---------------------------//
    public void Login(String usuario, String pass) throws SQLException {
        String sentencia = "SELECT NOMBRE FROM USUARIO WHERE NOMBRE='" + usuario + "' AND PASSWORD='" + pass + "'";
        Conj_Registros = Sentencia_SQL.executeQuery(sentencia);

    }

    public void existeUsuario(String usuario) throws SQLException {
        String sentencia = "SELECT NOMBRE FROM USUARIO WHERE NOMBRE='" + usuario + "'";
        Conj_Registros = Sentencia_SQL.executeQuery(sentencia);

    }

    public void existeEmail(String email) throws SQLException {
        String sentencia = "SELECT NOMBRE FROM USUARIO WHERE EMAIL='" + email + "'";
        Conj_Registros = Sentencia_SQL.executeQuery(sentencia);
    }

    public void existeCliente(String dni) throws SQLException {
        String sentencia = "SELECT DNI FROM CLIENTE WHERE DNI='" + dni + "'";
        Conj_Registros = Sentencia_SQL.executeQuery(sentencia);
    }

    
    public void existeEmpresa(String nif) throws SQLException {
        String sentencia = "SELECT NIF FROM EMPRESA WHERE NIF='" + nif + "'";
        Conj_Registros = Sentencia_SQL.executeQuery(sentencia);
    }

    public void insertarUsuario(Usuario user) throws SQLException {
        String sentencia = "INSERT INTO USUARIO VALUES ('"
                + user.getNombre()
                + "','" + user.getPassword()
                + "','" + user.getEmail()
                + "'," + user.getRol() + ",0,0)";
        Sentencia_SQL.executeUpdate(sentencia);

    }

    public void insertarDireccion(Direccion dir) throws SQLException {
        String sentencia="";
        if(dir.getTlfn2()!=0){
        
        sentencia = "INSERT INTO DIRECCION VALUES(NULL,'"
                + dir.getCalle()
                + "','" + dir.getPoblacion()
                + "','" + dir.getCp()
                + "','" + dir.getProvincia()
                + "','" + dir.getPais()
                + "','" + dir.getTlfn1()
                + "','" + dir.getTlfn2() + "')";
        Sentencia_SQL.executeUpdate(sentencia);
        }
        else{
             sentencia = "INSERT INTO DIRECCION VALUES(NULL, '"
                + dir.getCalle()
                + "','" + dir.getPoblacion()
                + "','" + dir.getCp()
                + "','" + dir.getProvincia()
                + "','" + dir.getPais()
                + "','" + dir.getTlfn1()
                +"',NULL)";
             Sentencia_SQL.executeUpdate(sentencia);
        }
    }

    public void getIdDireccion(Direccion dir) throws SQLException {
        String sentencia = "SELECT ID FROM DIRECCION WHERE CALLE = '" + dir.getCalle() + "'"
                + "AND POBLACION = '" + dir.getPoblacion() + "'"
                + "AND CODIGO_POSTAL = '" + dir.getCp() + "'"
                + "AND PROVINCIA = '" + dir.getProvincia() + "'"
                + "AND PAIS = '" + dir.getPais() + "'"
                + "AND TLFN1= '" + dir.getTlfn1() + "'";
        Conj_Registros = Sentencia_SQL.executeQuery(sentencia);
    }

    public void insertarCliente(Cliente cli, int idDir) throws SQLException {
            String sentencia = "INSERT INTO CLIENTE VALUES('"+cli.getDni()+
                    "','"+cli.getUser().getNombre()+
                    "','"+cli.getNombre()+
                    "','"+cli.getApe1()+
                    "','"+cli.getApe2()+
                    "','"+idDir+"')";
            Sentencia_SQL.executeUpdate(sentencia);
    }
     public void insertarEmpresa(Empresa em, int idDir) throws SQLException {
            String sentencia = "INSERT INTO EMPRESA VALUES('"+em.getNif()+
                     "','"+em.getNombre()+
                    "','"+em.getUser().getNombre()+
                    "','"+idDir+"')";
            Sentencia_SQL.executeUpdate(sentencia);
    }

    public int getRol(String usuario) throws SQLException {
        int rol;
        String sentencia = "SELECT ROL FROM USUARIO WHERE USUARIO ='" + usuario + "'";
        Conj_Registros = Sentencia_SQL.executeQuery(sentencia);
        Conj_Registros.next();
        rol = Conj_Registros.getInt("rol");

        return rol;
    }

    public void getUser(String usuario) throws SQLException {
        String sentencia = "SELECT NOMBRE, PASSWORD, EMAIL, ROL,USUARIOCONFIRMADO ,CONTRASENYACAMBIADA  FROM USUARIO WHERE NOMBRE ='" + usuario + "'";
        Conj_Registros = Sentencia_SQL.executeQuery(sentencia);
    }
    public void getUsers () throws SQLException {
        String sentencia = "SELECT NOMBRE, PASSWORD, EMAIL, ROL,USUARIOCONFIRMADO ,CONTRASENYACAMBIADA  FROM USUARIO";
        Conj_Registros  = Sentencia_SQL.executeQuery(sentencia);
    }
    public void BorrarUser(String usuario) throws SQLException{
        String sentencia = "DELETE FROM USUARIO WHERE NOMBRE = '"+usuario+"'";
        Sentencia_SQL.executeUpdate(sentencia);
    }
    public void getCliente_Direccion(String usuario)  throws SQLException{
        String sentencia = "SELECT U.EMAIL, U.USUARIOCONFIRMADO, C.DNI, C.NOMBRE, C.APELLIDO1, C.APELLIDO2, "
                + "D.CALLE, D.POBLACION, D.CODIGO_POSTAL, D.PROVINCIA, D.PAIS, D.TLFN1, D.TLFN2 "
                + "FROM USUARIO U, CLIENTE C , DIRECCION D "
                + "WHERE U.NOMBRE = '"+usuario+"' "
                + "AND C.USUARIO = '"+usuario+"' AND C.ID_DIRECCION = D.ID ";
        Conj_Registros = Sentencia_SQL.executeQuery(sentencia);
    }
    public void getEmpresa_Direccion(String usuario)  throws SQLException{
        String sentencia = "SELECT U.EMAIL, U.USUARIOCONFIRMADO, E.NIF, E.NOMBRE_EMPRESA, "
                + "D.CALLE, D.POBLACION, D.CODIGO_POSTAL, D.PROVINCIA , D.PAIS, D.TLFN1, D.TLFN2 "
                + "FROM USUARIO U, EMPRESA E , DIRECCION D "
                + "WHERE U.NOMBRE = '"+usuario+"' "
                + "AND E.USUARIO = '"+usuario+"' AND E.ID_DIRECCION = D.ID ";
        Conj_Registros = Sentencia_SQL.executeQuery(sentencia);
    }
    public void getUserSinConfirmar () throws SQLException{
        String sentencia = "SELECT NOMBRE, PASSWORD, EMAIL, ROL,USUARIOCONFIRMADO ,CONTRASENYACAMBIADA FROM USUARIO WHERE USUARIOCONFIRMADO = 0";
         Conj_Registros  = Sentencia_SQL.executeQuery(sentencia);
    }
    public void AceptarUsuario(String usuario) throws SQLException{
        String sentencia = "UPDATE USUARIO SET  USUARIOCONFIRMADO = 1 WHERE NOMBRE = '"+usuario+"'";
        Sentencia_SQL.executeUpdate(sentencia);
    }
 public void RechazarUsuario(String usuario) throws SQLException{
        String sentencia = "UPDATE USUARIO SET  USUARIOCONFIRMADO = 2 WHERE NOMBRE = '"+usuario+"'";
        Sentencia_SQL.executeUpdate(sentencia);
    }
    public void CambiarPass(String pass, String usuario) throws SQLException{
        String sentencia = "UPDATE USUARIO SET PASSWORD = '"+pass+"', CONTRASENYACAMBIADA = 1 WHERE NOMBRE = '"+usuario+"'";
        Sentencia_SQL.executeUpdate(sentencia);
    }
    
    //------------------------------------------ZONA USUARIO--------------------------//
    public void getProductoCat(int id) throws SQLException{
        String sentencia = "SELECT REF, NOMBRE, DESCRIPCION,ID_CATEGORIA, ID_SUBCATEGORIA, PRECIO1, PRECIO2, FICHA, IMAGEN FROM PRODUCTO WHERE ID_CATEGORIA  = "+id;
        Conj_Registros = Sentencia_SQL.executeQuery(sentencia);
    }
    
    public void getProductoSubCat (int id) throws SQLException{
        String sentencia = "SELECT REF, NOMBRE, DESCRIPCION,ID_CATEGORIA, ID_SUBCATEGORIA, PRECIO1, PRECIO2, FICHA, IMAGEN FROM PRODUCTO WHERE ID_SUBCATEGORIA  = "+id;
        Conj_Registros = Sentencia_SQL.executeQuery(sentencia);
    }
    
    public void getBusqueda(String parametro) throws SQLException{
        String sentencia = "SELECT REF, NOMBRE, DESCRIPCION,ID_CATEGORIA, ID_SUBCATEGORIA, PRECIO1, PRECIO2, FICHA, IMAGEN FROM PRODUCTO"
                + " WHERE UPPER(REF)  LIKE UPPER('%"+parametro+"%') "
                + "OR UPPER(NOMBRE) LIKE UPPER('%"+parametro+"%') "
                + "OR UPPER (DESCRIPCION) LIKE UPPER('%"+parametro+"%')";
        Conj_Registros = Sentencia_SQL.executeQuery(sentencia);
    }
    
    //-----------------------------------------Pedido---------------------//
    public void AgregarListaPedido ( String usuario, String DOC, int idDir, String fecha, int precio_total) throws SQLException{
       
        String sentencia = "INSERT INTO LISTA_PEDIDOS VALUES(NULL, "
                                                            + " '"+usuario+
                                                            "', '"+DOC+
                                                            "', "+idDir+
                                                            ", '"+fecha+
                                                            "' ,"+precio_total+", 0)";
        
        Sentencia_SQL.executeUpdate(sentencia);
        
       
    }
        public void AgregarPedido (String REF, String usuario, String DOC, int idDir,int precio,int cantidad, String fecha, int precio_total) throws SQLException{
       
       String sentencia = "SELECT ID FROM LISTA_PEDIDOS WHERE USUARIO ='"+usuario+"'"
                                                + " AND DNI_NIF = '"+DOC+" '"
                                                + " AND ID_DIR = "+idDir+
                                                  " AND FECHA = '"+fecha+" '"
                                                + " AND PRECIO_TOTAL = "+precio_total+"";
        Conj_Registros = Sentencia_SQL.executeQuery(sentencia);
        
        if(Obtener_Siguiente()){
            sentencia = "INSERT INTO PEDIDO VALUES (NULL,"+Obtener_Actual("ID")+" ,'"+REF+"'"
                                                        + ", "+precio/cantidad+","
                                                        + cantidad+")";
            Sentencia_SQL.executeUpdate(sentencia);
        }
    } 
    
    public void getCliente(String usuario) throws SQLException{
        String sentencia = "SELECT DNI, ID_DIRECCION FROM CLIENTE WHERE USUARIO = '"+usuario+"'";
        Conj_Registros = Sentencia_SQL.executeQuery(sentencia);
    }
    public void getEmpresa (String usuario) throws SQLException{
        String sentencia = "SELECT NIF, ID_DIRECCION FROM EMPRESA WHERE USUARIO = '"+usuario+"'";
        Conj_Registros = Sentencia_SQL.executeQuery(sentencia);
    }
    public void getAllPedido() throws SQLException{
        String sentencia = "SELECT ID, USUARIO, DNI_NIF, ID_DIR, FECHA, PRECIO_TOTAL, ACEPTADO FROM LISTA_PEDIDOS ORDER BY ACEPTADO DESC";
        Conj_Registros = Sentencia_SQL.executeQuery(sentencia);
    }
    public void AceptarPedido(int id)throws SQLException{
        String sentencia = "UPDATE LISTA_PEDIDOS SET ACEPTADO = 1 WHERE ID = "+id;
        Sentencia_SQL.executeUpdate(sentencia);
    }
    public void RechazarPedido(int id)throws SQLException{
        String sentencia = "UPDATE LISTA_PEDIDOS SET ACEPTADO = 2 WHERE ID = "+id;
        Sentencia_SQL.executeUpdate(sentencia);
    }
    public void getUsuarioPedido(int id)throws SQLException{
        String sentencia = "SELECT USUARIO FROM LISTA_PEDIDOS WHERE ID = "+id;
        Conj_Registros = Sentencia_SQL.executeQuery(sentencia);
    }
    public void getProductoPed(int id) throws SQLException{
        String sentencia = "SELECT ID, ID_LISTA_PED, PED.REF AS REF, PRO.NOMBRE AS NOMBRE , PRECIO, CANTIDAD FROM PEDIDO PED, PRODUCTO PRO WHERE PED.ID_LISTA_PED = "+id+" "
                + " AND PED.REF = PRO.REF";
       Conj_Registros = Sentencia_SQL.executeQuery(sentencia);
    }
    
    public void getDireccion(int id) throws SQLException{
        String sentencia = "SELECT CALLE, POBLACION, CODIGO_POSTAL, PROVINCIA, PAIS, TLFN1, TLFN2 FROM DIRECCION "
                + "WHERE ID = "+id;
        Conj_Registros = Sentencia_SQL.executeQuery(sentencia);
    }
    
}
    
