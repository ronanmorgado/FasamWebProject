package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import fasam.jdbc.Conexao;

/**
 *
 * @author Pedro Henrique
 */
public class PessoasDAO {
    private final static String INSERIR = "insert into pessoas (nome, email, senha) values (?, ?, ?)";
    
    public void salvar(Pessoas p) throws ClassNotFoundException{
        // Cria uma variável que receberá o objeto de conexão
        Connection conn = null;
        
        // Cria um objeto que receberá um PreparedStatement para enviar os comandos SQL
        PreparedStatement stmt = null;
        
        try {
            // Recebe uma conexão com o banco de dados.
            // Comentar sobre o desacoplamento desta abordagem(Mudança de banco).
        	Class.forName("com.mysql.jdbc.Driver");
            conn = Conexao.getConnection();
            // Atribui o PreparedStatement com o comando de inclusão
            stmt = conn.prepareStatement(INSERIR);
            // Atribui o parâmetro do comando SQL
            // atribui o nome
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getEmail());
            stmt.setString(3, p.getSenha());
            
            // executa o comando contido no stmt que insere a Pessoa no banco.
            stmt.execute();
            Logger.getLogger(PessoasDAO.class.getName()).log(Level.INFO, p + ", salvo com sucesso !");
        } catch (SQLException sqle) {
            Logger.getLogger(PessoasDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        finally{
            try {
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PessoasDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}