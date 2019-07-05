package br.com.casadocodigo.loja.conf;


import javax.ejb.Singleton;
import javax.jms.JMSDestinationDefinition;
@Singleton
@JMSDestinationDefinition(
    name="java:/jms/topics/CarrinhoComprasTopico",
    interfaceName="javax.jms.Topic"
)
public class ConfigureJMSDestination {

}