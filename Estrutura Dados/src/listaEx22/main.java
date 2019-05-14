package listaEx22;

import javax.swing.JOptionPane;	

public class main
{	
	public	static	NoMetodos lista = new	NoMetodos();
	
	public	static	String	    sIO,sTitle;
	public	static	String[]	sSN={"Sim","N�o"};
	public	static	int		iSN;
	public	static	String[]	sOpcao={"Inserir Elemento","Retirar Elemento","Sair"};
	public	static	int		iOpcao;

	public static void main(String Args[])
	{				
		//Tela inicial
		sTitle="ALGED-Ex22-2o.Semestre";
		sIO="Listas Singularmente Encadeadas";
		JOptionPane.showMessageDialog(null,sIO,sTitle,JOptionPane.PLAIN_MESSAGE);

		//Tela de menu
		do
		{
			sIO="Selecione o bot�o da op��o desejada:";
			iOpcao=JOptionPane.showOptionDialog(null,sIO,sTitle,1,JOptionPane.QUESTION_MESSAGE,null,sOpcao,null);
			switch(iOpcao)
			{
				case	0:	inserir_elemento();
							break;
				case	1:	retirar_elemento();
							break;
				case	2:	sIO="Deseja realmente sair agora?";
							iSN=JOptionPane.showOptionDialog(null,sIO,sTitle,1,JOptionPane.QUESTION_MESSAGE,null,sSN,null);
							if(iSN==1)	iOpcao=-1;
							break;
			}
		}while(iOpcao!=2);
				
		//Termina execu��o
      System.exit(0);
   }

	public	static	void	inserir_elemento()
	{
		sIO="Digite o n�mero a ser inserido na Lista:";
		if(lista.inserirNoFinal(Integer.parseInt(JOptionPane.showInputDialog(null,sIO,sTitle,JOptionPane.QUESTION_MESSAGE))))
				sIO="Inser��o na Lista com sucesso!";
		else	sIO="Problemas na Inser��o na Lista";
		JOptionPane.showMessageDialog(null,sIO,sTitle,JOptionPane.PLAIN_MESSAGE);
	}
	
	public	static	void	retirar_elemento()
	{
		sIO="";
		
		if(lista.isEmpty())	sIO="Lista Vazia!";
		else	sIO+=lista.removerDoFinal();
		JOptionPane.showMessageDialog(null,sIO,sTitle,JOptionPane.PLAIN_MESSAGE);
	}
}