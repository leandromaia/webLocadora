/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.bean;


public class VeiculoCliente {
    private Integer codVeiculoCliente;
    private Cliente cliente;
    private Veiculo veiculo;

    public Integer getCodVeiculoCliente() {
        return codVeiculoCliente;
    }

    public void setCodVeiculoCliente(Integer codVeiculoCliente) {
        this.codVeiculoCliente = codVeiculoCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

  
}
