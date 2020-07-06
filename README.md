[![Build_Status](https://travis-ci.org/tiagoadmstz/PdfSlider.svg?branch=master)](https://travis-ci.org/tiagoadmstz/PdfSlider)

# PdfSlider
Sistema que transforma um arquivo pdf em uma apresentação de slides que pode ser programada para trocar de arquivo e passar as páginas de tempo em tempo.

#Arquivo de Configuração
O arquivo de configuração deve ficar dentro da pasta do sistema no diretório "conf" com o seguinte formato:

```
{
  "icone": "C:\\Users\\root\\Desktop\\pdfslider\\icon.jpeg",
  "arquivos": "C:\\Users\\root\\Desktop\\pdfslider\\Cartilha de recomendações II.pdf",
  "tempo-pagina": "00h00m10s",
  "tempo-arquivo": "00h01m00s",
  "comprimento": 800,
  "altura": 600,
  "loop-arquivos": true
}
```

Caso o diretório ou arquivo não existam o sistema os criará usando padrãos internos.

![configurationFrame](https://github.com/tiagoadmstz/PdfSlider/blob/master/configurationFrame.jpg)

Após fazer as configurações e confirmar o sistema salva as configurações no arquivo e abre a dela de apresentação. Os arquivos podem ser trocados com o programa em execução e dependendo do tamanho do arquivo pode demorar alguns segundos para mostrar a primeira página.

![slider1](https://github.com/tiagoadmstz/PdfSlider/blob/master/slider1.jpg)

Pode-se também parar a apresentação e mudar manualmente. O controle podem ser tirado da tela e fechado para mostrar somente o conteúdo das páginas.

![slider2](https://github.com/tiagoadmstz/PdfSlider/blob/master/slider2.jpg)
