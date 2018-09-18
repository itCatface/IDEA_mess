from reportlab.pdfgen import canvas


def main():
    c = canvas.Canvas('hi.pdf')
    c.drawString(100, 100, 'hi')
    c.showPage()
    c.save()


if __name__ == '__main__':
    main()
