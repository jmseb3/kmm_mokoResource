import SwiftUI
import shared

struct ContentView: View {
	var body: some View {
        VStack {
            Text(StringsKt.getMyDesc().localized())
            Text(StringsKt.getMyFormatDesc(input: "이것은").localized())
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
